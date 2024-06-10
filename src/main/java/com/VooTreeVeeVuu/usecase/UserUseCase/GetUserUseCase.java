package com.VooTreeVeeVuu.usecase.UserUseCase;

import com.VooTreeVeeVuu.adapters.dto.UserDTO;
import com.VooTreeVeeVuu.domain.entity.User;
import com.VooTreeVeeVuu.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserUseCase {
	@Autowired
	private UserRepository userRepository;

	public Optional<UserDTO> getUserById (Long id) {
		return userRepository.findById(id).map(this :: toDTO);
	}

	private UserDTO toDTO (User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		userDTO.setDob(String.valueOf(user.getDob()));
		userDTO.setGender(user.getGender());
		return userDTO;
	}
}
