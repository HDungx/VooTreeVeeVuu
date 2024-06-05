package com.VooTreeVeeVuu.services;

import com.VooTreeVeeVuu.adapters.dto.AuthenticationResponse;
import com.VooTreeVeeVuu.adapters.dto.LoginDTO;
import com.VooTreeVeeVuu.adapters.dto.SignUpDTO;
import com.VooTreeVeeVuu.adapters.repository.JpaAccountRepository;
import com.VooTreeVeeVuu.adapters.repository.JpaRoleRepository;
import com.VooTreeVeeVuu.domain.entity.Account;
import com.VooTreeVeeVuu.domain.entity.Role;
import com.VooTreeVeeVuu.domain.entity.User;
import com.VooTreeVeeVuu.domain.utils.RoleName;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	private final JpaAccountRepository accountRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtils jwtService;
	private final AuthenticationManager authenticationManager;
	private final JpaRoleRepository roleRepository;

	public AuthenticationResponse register (SignUpDTO request) {
		var account = Account.builder().username(request.getUsername()).password(
				passwordEncoder.encode(request.getPassword())).email(request.getEmail()).build();
		Set<String> rolesString = request.getRoles();
		Set<Role> roles = new HashSet<>();
		if (rolesString == null)
		{
			Role userRole = roleRepository.findByName(RoleName.CUSTOMER).orElseThrow(
					() -> new RuntimeException("Role customer not found"));
			roles.add(userRole);
		} else
		{
			rolesString.forEach(role -> {
				if (role.equals("ADMIN"))
				{
					Role adminRole = roleRepository.findByName(RoleName.ADMIN).orElseThrow(
							() -> new RuntimeException("Role not found"));
					roles.add(adminRole);
				} else if (role.equals("STAFF"))
				{
					Role staffRole = roleRepository.findByName(RoleName.STAFF).orElseThrow(
							() -> new RuntimeException("Role not found"));
					roles.add(staffRole);
				} else if (role.equals("PARTNER"))
				{
					Role partnerRole = roleRepository.findByName(RoleName.PARTNER).orElseThrow(
							() -> new RuntimeException("Role not found"));
					roles.add(partnerRole);
				} else
				{
					Role userRole = roleRepository.findByName(RoleName.CUSTOMER).orElseThrow(
							() -> new RuntimeException("Role customer not found"));
					roles.add(userRole);
				}
			});
		}
		account.setRoles(roles);

		User user = new User();
		user.setDob(request.getDob());
		account.setUser(user);
		user.setAccount(account);

		accountRepository.save(account);
		var jwtToken = jwtService.generateToken(account);
		return AuthenticationResponse.builder().token(jwtToken).build();
	}

	public AuthenticationResponse login (LoginDTO request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		var account = accountRepository.findByUsername(request.getUsername()).orElseThrow();
		var jwtToken = jwtService.generateToken(account);
		return AuthenticationResponse.builder().token(jwtToken).date(request.getDate()).build();
	}
}
