package com.VooTreeVeeVuu.controller;

import com.VooTreeVeeVuu.dto.AuthenticationResponse;
import com.VooTreeVeeVuu.dto.LoginDTO;
import com.VooTreeVeeVuu.dto.SignUpDTO;
import com.VooTreeVeeVuu.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin ("*")
@RestController
@RequestMapping ("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
	private final AuthenticationService service;

	@PostMapping ("/register")
	public ResponseEntity<AuthenticationResponse> register (@RequestBody SignUpDTO request) {
		return ResponseEntity.ok(service.register(request));
	}

	@PostMapping ("/login")
	public ResponseEntity<AuthenticationResponse> login (@RequestBody LoginDTO request) {
		return ResponseEntity.ok(service.login(request));

	}

}
