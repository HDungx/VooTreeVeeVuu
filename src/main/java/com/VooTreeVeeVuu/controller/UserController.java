package com.VooTreeVeeVuu.controller;

import com.VooTreeVeeVuu.dto.UserDTO;
import com.VooTreeVeeVuu.usecase.UserUseCase.GetAllUserUseCase;
import com.VooTreeVeeVuu.usecase.UserUseCase.GetUserUseCase;
import com.VooTreeVeeVuu.usecase.UserUseCase.UpdateUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin ("*")
@RestController
@RequestMapping ("/api/users")
public class UserController {
	@Autowired
	private GetAllUserUseCase getAllUserUseCase;

	@Autowired
	private GetUserUseCase getUserUseCase;

	@Autowired
	private UpdateUserUseCase updateUserUseCase;

	@GetMapping ()
	public List<UserDTO> getAllUsers () {
		return getAllUserUseCase.getAllUsers();
	}

	@GetMapping ("/{id}")
	public Optional<UserDTO> getUserById (@PathVariable Long id) {
		return getUserUseCase.getUserById(id);
	}

	@PutMapping ("/update/{id}")
	public Optional<UserDTO> updateUser (@PathVariable Long id, @RequestBody UserDTO userDTO) {
		return updateUserUseCase.updateUser(id, userDTO);
	}
}
