package com.VooTreeVeeVuu.usecase.RoleUseCases;

import com.VooTreeVeeVuu.domain.repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteRoleUseCase {
	@Autowired
	private RoleRepository roleRepository;

	@Transactional
	public void deleteRole (Long id) {
		roleRepository.deleteById(id);
	}
}
