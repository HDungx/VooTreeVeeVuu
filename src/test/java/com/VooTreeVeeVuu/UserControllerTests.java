package com.VooTreeVeeVuu;

import com.VooTreeVeeVuu.controller.UserController;
import com.VooTreeVeeVuu.domain.entity.Account;
import com.VooTreeVeeVuu.domain.utils.Gender;
import com.VooTreeVeeVuu.dto.UserDTO;
import com.VooTreeVeeVuu.usecase.UserUseCase.GetAllUser.GetAllUserImpl;
import com.VooTreeVeeVuu.usecase.UserUseCase.GetUser.GetUserImpl;
import com.VooTreeVeeVuu.usecase.UserUseCase.UpdateUser.UpdateUserImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class UserControllerTests {
	@Mock
	private MockMvc mockMvc;

	@InjectMocks
	private UserController userController;

	@Mock
	private GetAllUserImpl getAllUserUseCase;

	@Mock
	private GetUserImpl getUserUseCase;

	@Mock
	private UpdateUserImpl updateUserUseCase;

	@BeforeEach
	public void setUp () {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}


	@Test
	public void testGetAllUsers () throws Exception {
		// Arrange
		UserDTO user1 = new UserDTO();
		user1.setId(1L);
		user1.setFirstName("John");
		user1.setLastName("Doe");
		user1.setDob("1990-01-01");
		user1.setGender(Gender.MALE); // Adjust if Gender is an enum
		user1.setAccount(new Account()); // Set as needed

		UserDTO user2 = new UserDTO();
		user2.setId(2L);
		user2.setFirstName("Jane");
		user2.setLastName("Smith");
		user2.setDob("1985-05-05");
		user2.setGender(Gender.FEMALE); // Adjust if Gender is an enum
		user2.setAccount(new Account()); // Set as needed

		List<UserDTO> userList = Arrays.asList(user1, user2);

		Mockito.when(getAllUserUseCase.getAllUsers()).thenReturn(userList);

		// Act & Assert
		mockMvc.perform(get("/api/users") // Adjust the endpoint as needed
						.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(
						content().contentType(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$[0].id").value(1)).andExpect(
						jsonPath("$[0].firstName").value("John")).andExpect(jsonPath("$[0].lastName").value("Doe")).andExpect(
						jsonPath("$[0].dob").value("1990-01-01")).andExpect(
						jsonPath("$[0].gender").value("MALE")) // Adjust if Gender is an enum
				.andExpect(jsonPath("$[1].id").value(2)).andExpect(jsonPath("$[1].firstName").value("Jane")).andExpect(
						jsonPath("$[1].lastName").value("Smith")).andExpect(jsonPath("$[1].dob").value("1985-05-05")).andExpect(
						jsonPath("$[1].gender").value("FEMALE")); // Adjust if Gender is an enum
	}

	@Test
	public void testGetUserById () throws Exception {
		
		Long userId = 1L;
		UserDTO userDTO = new UserDTO(userId, "John", "Doe", "1990-01-01", Gender.MALE, null);

		// Mock service to return the user by id
		Mockito.when(getUserUseCase.getUserById(userId)).thenReturn(userDTO);

		// Send request to GET /api/users/{id} and expect the user in response
		mockMvc.perform(
						MockMvcRequestBuilders.get("/api/users/" + userId).contentType(MediaType.APPLICATION_JSON)).andExpect(
						status().isOk()).andExpect(jsonPath("$.id").value(userId)).andExpect(
						jsonPath("$.firstName").value("John")).andExpect(jsonPath("$.lastName").value("Doe")).andExpect(
						jsonPath("$.dob").value("1990-01-01")).andExpect(jsonPath("$.gender").value("MALE"))
//                    .andExpect(MockMvcResultMatchers.jsonPath("$.account").value(""))
				.andDo(print());
	}

	@Test
	public void testUpdateUser () throws Exception {
		Long userId = 1L;
		UserDTO userDTO = new UserDTO(userId, "John", "Doe", "1990-01-01", Gender.MALE, null);

		// Mock service to return updated user
		Mockito.when(updateUserUseCase.updateUser(userId, userDTO)).thenReturn(Optional.of(userDTO));

		// JSON representation of the userDTO to be sent in the request body
		String userJson = "{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Doe\",\"dob\":\"1990-01-01\",\"gender\":\"MALE\"}";

		// Send request to PUT /api/users/update/{id} with user data and expect the updated user in response
		mockMvc.perform(MockMvcRequestBuilders.put("/api/users/update/" + userId).contentType(
						MediaType.APPLICATION_JSON).content(userJson)).andExpect(status().isOk())
//                    .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(userId))
				.andExpect(jsonPath("$.firstName").value("John")).andExpect(
						jsonPath("$.lastName").value("Doe")).andExpect(jsonPath("$.dob").value("1990-01-01")).andExpect(
						jsonPath("$.gender").value("MALE")).andDo(print());
	}

}
