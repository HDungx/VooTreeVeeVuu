package com.VooTreeVeeVuu.adapters.controller;

import com.VooTreeVeeVuu.adapters.dto.RoleDTO;
import com.VooTreeVeeVuu.domain.utils.RoleName;
import com.VooTreeVeeVuu.usecase.RoleUseCases.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin ("*")
@RestController
@RequestMapping ("/api/roles")
public class RoleController {
	@Autowired
	private GetAllRoleUseCase getAllRoleUseCase;

	@Autowired
	private GetRoleUseCase getRoleUseCase;

	@Autowired
	private CreateRoleUseCase createRoleUseCase;

	@Autowired
	private DeleteRoleUseCase deleteRoleUseCase;

	@Autowired
	private FindRoleByNameUseCase findRoleByNameUseCase;

	@Autowired
	private UpdateRoleUseCase updateRoleUseCase;

	@GetMapping ()
	public List<RoleDTO> getAllRoles () {
		return getAllRoleUseCase.getAllRoles();
	}

	@GetMapping ("/{id}")
	public Optional<RoleDTO> getRole (@PathVariable Long id) {
		return Optional.of(
				getRoleUseCase.getRoleById(id).orElseThrow(() -> new IllegalArgumentException("Role not found")));
	}

	@GetMapping ("/search")
	public List<RoleDTO> findRoleByName (@RequestParam RoleName name) {
		return findRoleByNameUseCase.getRoleByName(name);
	}

	@PostMapping
	public RoleDTO createRole (@RequestBody RoleDTO roleDTO) {
		return createRoleUseCase.createRole(roleDTO.getName());
	}

	@PutMapping ("/{id}")
	public Optional<RoleDTO> updateRole (@RequestBody RoleDTO roleDTO, @PathVariable Long id) {
		return updateRoleUseCase.updateRole(id, roleDTO);
	}

	@DeleteMapping ("/{id}")
	public void deleteRole (@PathVariable Long id) {
		deleteRoleUseCase.deleteRole(id);
	}

}
