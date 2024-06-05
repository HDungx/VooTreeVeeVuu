package com.VooTreeVeeVuu.adapters.repository;

import com.VooTreeVeeVuu.domain.entity.Role;
import com.VooTreeVeeVuu.domain.repository.RoleRepository;
import com.VooTreeVeeVuu.domain.utils.RoleName;


import java.util.Optional;

public interface JpaRoleRepository extends RoleRepository {
	Optional<Role> findByName (RoleName name);
}
