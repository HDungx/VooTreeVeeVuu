package com.VooTreeVeeVuu;

import com.VooTreeVeeVuu.controller.RoleController;
import com.VooTreeVeeVuu.domain.utils.RoleName;
import com.VooTreeVeeVuu.dto.RoleDTO;
import com.VooTreeVeeVuu.usecase.RoleUseCases.CreateRole.CreateRoleImpl;
import com.VooTreeVeeVuu.usecase.RoleUseCases.DeleteRole.DeleteRoleImpl;
import com.VooTreeVeeVuu.usecase.RoleUseCases.FindRoleByName.FindRoleByNameImpl;
import com.VooTreeVeeVuu.usecase.RoleUseCases.GetAllRole.GetAllRoleImpl;
import com.VooTreeVeeVuu.usecase.RoleUseCases.GetRole.GetRoleImpl;
import com.VooTreeVeeVuu.usecase.RoleUseCases.UpdateRole.UpdateRoleImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class RoleControllerUnitTest {
	@Mock
	private MockMvc mockMvc;

	@InjectMocks
	private RoleController roleController;

	@Mock
	private GetAllRoleImpl getAllRoleUseCase;

	@Mock
	private CreateRoleImpl createRole;
	@Mock
	private FindRoleByNameImpl findRoleByNameUseCase;

	@Mock
	private GetRoleImpl getRole;

	@Mock
	private UpdateRoleImpl updateRoleUseCase;

	@Mock
	private DeleteRoleImpl deleteRoleUseCase;
	@BeforeEach
	public void setUp () {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(roleController).build();
	}

	private List<RoleDTO> roleDTOS(){
		RoleDTO roleDTO1 = new RoleDTO(1L, RoleName.ADMIN);
		RoleDTO roleDTO2 = new RoleDTO(2L, RoleName.STAFF);
		RoleDTO roleDTO3 = new RoleDTO(3L, RoleName.PARTNER);
		RoleDTO roleDTO4 = new RoleDTO(4L, RoleName.CUSTOMER);
		return Arrays.asList(roleDTO1, roleDTO2, roleDTO3, roleDTO4);
	}


	private static final String END_POINT_PATH="/api/roles";
	@Test
	public void testGetAllRole () throws Exception {

		// Mock service return as list
		Mockito.when(getAllRoleUseCase.getAllRoles()).thenReturn(roleDTOS());

		// create mock with needed test controller
		mockMvc = MockMvcBuilders.standaloneSetup(roleController).build();

		// send request to GET /url with expectedValue
		mockMvc.perform(MockMvcRequestBuilders.get(END_POINT_PATH).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1L))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("ADMIN"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2L))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("STAFF"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[2].id").value(3L))
				.andExpect(MockMvcResultMatchers.jsonPath("$[2].name").value("PARTNER"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[3].id").value(4L))
				.andExpect(MockMvcResultMatchers.jsonPath("$[3].name").value("CUSTOMER"))
				.andDo(print());
	}

	@Test
	public void testGetRoleById () throws Exception {
		// Mock service return a role by id
		Long roleId = 1L;
		RoleDTO roleDTO = new RoleDTO(roleId, RoleName.ADMIN);

		Mockito.when(getRole.getRoleById(roleId)).thenReturn(Optional.of(roleDTO));

		// send request to GET /api/roles/{id} with expectedValue
		mockMvc.perform(MockMvcRequestBuilders.get(END_POINT_PATH + "/" + roleId)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(roleId))
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("ADMIN"))
				.andDo(print());
	}



	@Test
	public void testGetRoleById_NotFound() throws Exception {
		// Mock service to return empty when role is not found
		Long roleId = 999L;

		Mockito.when(getRole.getRoleById(roleId)).thenReturn(Optional.empty());

		// send request to GET /api/roles/{id} and expect an error
		mockMvc.perform(MockMvcRequestBuilders.get(END_POINT_PATH + "/" + roleId)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andExpect(MockMvcResultMatchers.content().string("Role not found"))
				.andDo(print());
	}

	@Test
	public void testFindRoleByName() throws Exception {
		// Mock service return a role by name
		RoleName roleName = RoleName.ADMIN;
		RoleDTO roleDTO = new RoleDTO(1L, roleName);

		Mockito.when(findRoleByNameUseCase.getRoleByName(roleName)).thenReturn(Arrays.asList(roleDTO));

		// send request to GET /api/roles/search with expectedValue
		mockMvc.perform(MockMvcRequestBuilders.get(END_POINT_PATH + "/search")
						.param("name", roleName.toString())
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1L))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("ADMIN"))
				.andDo(print());
	}


	@Test
	public void testCreateRole() throws Exception {
		RoleDTO newRoleDTO = new RoleDTO(null, RoleName.ADMIN);
		RoleDTO createdRoleDTO = new RoleDTO(1L, RoleName.ADMIN);

		// Mock service return the created role
		Mockito.when(createRole.createRole(newRoleDTO.getName())).thenReturn(createdRoleDTO);

		// JSON representation of the roleDTO to be sent in the request body
		String roleJson = "{\"name\":\"ADMIN\"}";

		// send request to POST /api/roles with role data and expect a created role in response
		mockMvc.perform(MockMvcRequestBuilders.post(END_POINT_PATH)
						.contentType(MediaType.APPLICATION_JSON)
						.content(roleJson))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("ADMIN"))
				.andDo(print());
	}

	@Test
	public void testUpdateRole() throws Exception {
		Long roleId = 1L;
		RoleDTO roleDTO = new RoleDTO(roleId, RoleName.ADMIN);

		// Mock service to return updated role
		Mockito.when(updateRoleUseCase.updateRole(roleId, roleDTO)).thenReturn(Optional.of(roleDTO));

		// JSON representation of the roleDTO to be sent in the request body
		String roleJson = "{\"id\":1,\"name\":\"ADMIN\"}";

		// send request to PUT /api/roles/{id} with role data and expect the updated role in response
		mockMvc.perform(MockMvcRequestBuilders.put(END_POINT_PATH+ "/" + roleId)
						.contentType(MediaType.APPLICATION_JSON)
						.content(roleJson))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("ADMIN"))
				.andDo(print());
	}

	@Test
	public void testDeleteRole() throws Exception {
		Long roleId = 1L;

		// Mock service to do nothing when delete role
		Mockito.doNothing().when(deleteRoleUseCase).deleteRole(roleId);

		// send request to DELETE /api/roles/{id} and expect no content in response
		mockMvc.perform(MockMvcRequestBuilders.delete(END_POINT_PATH+ "/" + roleId)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(print());
	}

}
