package com.VooTreeVeeVuu;

import com.VooTreeVeeVuu.controller.AccountController;
import com.VooTreeVeeVuu.domain.entity.User;
import com.VooTreeVeeVuu.domain.utils.Gender;
import com.VooTreeVeeVuu.dto.AccountDTO;
import com.VooTreeVeeVuu.dto.PassChangeDTO;
import com.VooTreeVeeVuu.services.AccountService;
import com.VooTreeVeeVuu.usecase.AccountUseCase.GetAccount.GetAccountImpl;
import com.VooTreeVeeVuu.usecase.AccountUseCase.GetAllAccounts.GetAllAccountsImpl;
import com.VooTreeVeeVuu.usecase.AccountUseCase.GetUserEmail.GetEmailByUserId;
import com.VooTreeVeeVuu.usecase.AccountUseCase.UpdateAccount.UpdateStatusImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class AccountControllerTests {

	@Mock
	private MockMvc mockMvc;

	@Mock
	private GetAllAccountsImpl getAllAccountsUseCase;

	@InjectMocks
	private AccountController accountController;

	@Mock
	private GetEmailByUserId getEmailByUserId;
	@Mock

	private GetAccountImpl getAccountUseCase;

	@Mock
	private UpdateStatusImpl updateStatusUseCase;

	@Mock
	private AccountService accountService;

	@BeforeEach
	public void setUp () {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
	}

	@Test
	@DisplayName ("Test GET /accounts - Success")
	public void testGetAllAccounts () throws Exception {
		// Mock data
		List<AccountDTO> accounts = Arrays.asList(
				createAccountDTO(1L, "john_doe", "password123", "john.doe@example.com", "1234567890", true,
						createTestUser(1L, "John", "Doe", Gender.MALE, "1990-01-01")),
				createAccountDTO(2L, "jane_smith", "password123", "jane.smith@example.com", "0987654321", true,
						createTestUser(2L, "Jane", "Smith", Gender.FEMALE, "1985-05-05"))
				// Add more accounts as needed
		);

		// Mock service method
		when(getAllAccountsUseCase.getAllAccounts()).thenReturn(accounts);

		// Perform GET request
		mockMvc.perform(get("/api/accounts").contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(
				MockMvcResultMatchers.jsonPath("$").isArray()).andExpect(
				MockMvcResultMatchers.jsonPath("$[0].id").value(1)).andExpect(
				MockMvcResultMatchers.jsonPath("$[0].username").value("john_doe")).andExpect(
				MockMvcResultMatchers.jsonPath("$[0].password").value("password123")).andExpect(
				MockMvcResultMatchers.jsonPath("$[0].email").value("john.doe@example.com")).andExpect(
				MockMvcResultMatchers.jsonPath("$[0].phoneNum").value("1234567890")).andExpect(
				MockMvcResultMatchers.jsonPath("$[0].enabled").value(true)).andExpect(
				MockMvcResultMatchers.jsonPath("$[0].user.id").value(1)).andExpect(
				MockMvcResultMatchers.jsonPath("$[0].user.firstName").value("John")).andExpect(
				MockMvcResultMatchers.jsonPath("$[0].user.lastName").value("Doe")).andExpect(
				MockMvcResultMatchers.jsonPath("$[0].user.gender").value("MALE")).andExpect(
				MockMvcResultMatchers.jsonPath("$[0].user.dob").value(Matchers.contains(1990, 1, 1))).andExpect(
				MockMvcResultMatchers.jsonPath("$[1].id").value(2)).andExpect(
				MockMvcResultMatchers.jsonPath("$[1].username").value("jane_smith")).andExpect(
				MockMvcResultMatchers.jsonPath("$[1].password").value("password123")).andExpect(
				MockMvcResultMatchers.jsonPath("$[1].email").value("jane.smith@example.com")).andExpect(
				MockMvcResultMatchers.jsonPath("$[1].phoneNum").value("0987654321")).andExpect(
				MockMvcResultMatchers.jsonPath("$[1].enabled").value(true)).andExpect(
				MockMvcResultMatchers.jsonPath("$[1].user.id").value(2)).andExpect(
				MockMvcResultMatchers.jsonPath("$[1].user.firstName").value("Jane")).andExpect(
				MockMvcResultMatchers.jsonPath("$[1].user.lastName").value("Smith")).andExpect(
				MockMvcResultMatchers.jsonPath("$[1].user.gender").value("FEMALE")).andExpect(
				MockMvcResultMatchers.jsonPath("$[1].user.dob").value(Matchers.contains(1985, 5, 5)));
	}

	// Helper method to create AccountDTO objects
	private AccountDTO createAccountDTO (Long id, String username, String password, String email, String phoneNum,
	                                     boolean enabled, User user) {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setId(id);
		accountDTO.setUsername(username);
		accountDTO.setPassword(password);
		accountDTO.setEmail(email);
		accountDTO.setPhoneNum(phoneNum);
		accountDTO.setEnabled(enabled);
		accountDTO.setUser(user);
		return accountDTO;
	}

	// Helper method to create User objects
	private User createTestUser (Long id, String firstName, String lastName, Gender gender, String dob) {
		return new User(id, firstName, lastName, gender, LocalDate.parse(dob));
	}


	@Test
	@DisplayName ("Test GET /api/accounts/{id} - Success")
	public void testGetAccountById () throws Exception {
		// Mock data
		AccountDTO accountDTO = createAccountDTO(1L, "john_doe", "password123", "john.doe@example.com", "1234567890",
				true, null);
		Optional<AccountDTO> optionalAccountDTO = Optional.of(accountDTO);

		// Mock service method
		when(getAccountUseCase.getAccountById(anyLong())).thenReturn(optionalAccountDTO);

		// Perform GET request
		mockMvc.perform(get("/api/accounts/{id}", 1L).contentType(MediaType.APPLICATION_JSON)).andExpect(
				status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(
				MockMvcResultMatchers.jsonPath("$.id").value(1)).andExpect(
				MockMvcResultMatchers.jsonPath("$.username").value("john_doe")).andExpect(
				MockMvcResultMatchers.jsonPath("$.password").value("password123")).andExpect(
				MockMvcResultMatchers.jsonPath("$.email").value("john.doe@example.com")).andExpect(
				MockMvcResultMatchers.jsonPath("$.phoneNum").value("1234567890")).andExpect(
				MockMvcResultMatchers.jsonPath("$.enabled").value(true)).andExpect(
				MockMvcResultMatchers.jsonPath("$.user").doesNotExist()); // Assuming user field should be null
	}


	@Test
	@DisplayName ("Test GET /accounts/email/{id} - Success")
	public void testGetEmailByUserId () throws Exception {
		// Mock data
		AccountDTO accountDTO = createAccountDTO(1L, "john_doe", "password123", "john.doe@example.com", "1234567890",
				true, null);
		Optional<AccountDTO> optionalAccountDTO = Optional.of(accountDTO);

		// Mock service method
		when(getEmailByUserId.getEmailByUserId(anyLong())).thenReturn(optionalAccountDTO);

		// Perform GET request
		mockMvc.perform(get("/api/accounts/email/{id}", 1L)).andExpect(status().isOk()).andExpect(
				content().contentType(MediaType.APPLICATION_JSON)).andExpect(
				MockMvcResultMatchers.jsonPath("$.id").value(1)).andExpect(
				MockMvcResultMatchers.jsonPath("$.username").value("john_doe")).andExpect(
				MockMvcResultMatchers.jsonPath("$.password").value("password123")).andExpect(
				MockMvcResultMatchers.jsonPath("$.email").value("john.doe@example.com")).andExpect(
				MockMvcResultMatchers.jsonPath("$.phoneNum").value("1234567890")).andExpect(
				MockMvcResultMatchers.jsonPath("$.enabled").value(true)).andExpect(
				MockMvcResultMatchers.jsonPath("$.user").doesNotExist()); // Assuming user field should be null
	}

	@Test
	public void testUpdateAccountStatus() throws Exception {
		// Arrange
		Long accountId = 1L;
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setId(accountId);
		accountDTO.setEnabled(false);

		when(updateStatusUseCase.updateStatus(anyLong(), any(AccountDTO.class)))
				.thenReturn(Optional.of(accountDTO));
		ObjectMapper objectMapper = new ObjectMapper();
		// Act & Assert
		mockMvc.perform(MockMvcRequestBuilders.put("/api/accounts/update/{id}", accountId)
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(accountDTO)))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(objectMapper.writeValueAsString(accountDTO)))
				.andExpect(jsonPath("$.enabled").value(false));
	}

	@Test
	public void testChangePassword() throws Exception {
		// Arrange
		Long accountId = 1L;
		PassChangeDTO passChangeDTO = new PassChangeDTO();
		passChangeDTO.setOldPassword("oldPass");
		passChangeDTO.setNewPassword("newPass");
		passChangeDTO.setConfPassword("newPass");

		doNothing().when(accountService).changePassword(anyLong(), any(PassChangeDTO.class));

		ObjectMapper objectMapper = new ObjectMapper();
		// Act & Assert
		mockMvc.perform(MockMvcRequestBuilders.put("/api/accounts/{id}/change-pass", accountId)
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(passChangeDTO)))
				.andExpect(status().isOk())
				.andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
				.andExpect(content().string("Password has been changed successfully"));
	}

	@Test
	public void testUploadAvatar_Success() throws Exception {
		// Arrange
		Long accountId = 1L;
		InputStream inputStream = getClass().getResourceAsStream("/logo2.png");
		MockMultipartFile file = new MockMultipartFile("avatar", "logo2.png", MediaType.IMAGE_JPEG_VALUE,
		 IOUtils.toByteArray(inputStream));

		doNothing().when(accountService).updateAvatar(anyLong(), any(MockMultipartFile.class));

		// Act & Assert
		mockMvc.perform(MockMvcRequestBuilders.multipart("/api/accounts/{id}/avatar", accountId)
						.file(file)
						.contentType(MediaType.MULTIPART_FORM_DATA))
				.andExpect(status().isOk())
				.andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
				.andExpect(content().string("Avatar uploaded successfully"));
	}

	@Test
	public void testGetAvatar_Success() throws Exception {
		// Arrange
		Long accountId = 1L;
		byte[] avatar = "fakeImageData".getBytes();

		when(accountService.getAvatar(anyLong())).thenReturn(avatar);

		// Act & Assert
		mockMvc.perform(MockMvcRequestBuilders.get("/api/accounts/{id}/avatar", accountId))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.IMAGE_JPEG))
				.andExpect(content().bytes(avatar));
	}
}