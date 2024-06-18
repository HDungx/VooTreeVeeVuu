package com.VooTreeVeeVuu.usecase.UserUseCase.GetUser;

import com.VooTreeVeeVuu.dto.UserDTO;

import java.util.Optional;

public interface GetUser {
	Optional<UserDTO> getUserById (Long id);
}
