package com.VooTreeVeeVuu;

import com.VooTreeVeeVuu.controller.RoleController;
import com.VooTreeVeeVuu.dto.RoleDTO;
import com.VooTreeVeeVuu.domain.utils.RoleName;
import com.VooTreeVeeVuu.usecase.RoleUseCases.GetAllRole.GetAllRoleUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

public class RoleControllerUnitTest {
	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private RoleController roleController;

	@Mock
	private GetAllRoleUseCase getAllRoleUseCase;

	@BeforeEach
	public void setUp () {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(roleController).build();
	}

	@Test
	public void testGetAllRole () throws Exception {
		// List of role defined
		RoleDTO roleDTO1 = new RoleDTO(1L, RoleName.ADMIN);
		RoleDTO roleDTO2 = new RoleDTO(2L, RoleName.STAFF);
		RoleDTO roleDTO3 = new RoleDTO(3L, RoleName.PARTNER);
		RoleDTO roleDTO4 = new RoleDTO(4L, RoleName.CUSTOMER);

		// Mock service return as list
		Mockito.when(getAllRoleUseCase.getAllRoles()).thenReturn(Arrays.asList(roleDTO1, roleDTO2, roleDTO3, roleDTO4));

		// create mock with needed test controller
		mockMvc = MockMvcBuilders.standaloneSetup(roleController).build();

		// send request to GET /url with expectedValue
		mockMvc.perform(MockMvcRequestBuilders.get("/api/roles").contentType(MediaType.APPLICATION_JSON)).andExpect(
				MockMvcResultMatchers.status().isOk()).andExpect(
				MockMvcResultMatchers.jsonPath("$[0].id").value(1L)).andExpect(
				MockMvcResultMatchers.jsonPath("$[0].name").value("ADMIN")).andExpect(
				MockMvcResultMatchers.jsonPath("$[1].id").value(2L)).andExpect(
				MockMvcResultMatchers.jsonPath("$[1].name").value("STAFF")).andExpect(
				MockMvcResultMatchers.jsonPath("$[2].id").value(3L)).andExpect(
				MockMvcResultMatchers.jsonPath("$[2].name").value("PARTNER")).andExpect(
				MockMvcResultMatchers.jsonPath("$[3].id").value(4L)).andExpect(
				MockMvcResultMatchers.jsonPath("$[3].name").value("CUSTOMER"));
	}

	@Test
	public void testGetRoleById () throws Exception {

	}

	@Test
	public void testGetRoleByName () throws Exception {

	}

}
