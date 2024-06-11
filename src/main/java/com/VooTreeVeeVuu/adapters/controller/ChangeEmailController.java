package com.VooTreeVeeVuu.adapters.controller;

import com.VooTreeVeeVuu.usecase.AccountUseCase.ChangeEmailRequestUseCase;
import com.VooTreeVeeVuu.usecase.AccountUseCase.VerifyAndChangeEmailUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin ("*")
@RestController
@RequestMapping ("/api/email")
public class ChangeEmailController {
	@Autowired
	private ChangeEmailRequestUseCase changeEmailRequestUseCase;

	@Autowired
	private VerifyAndChangeEmailUseCase verifyAndChangeEmailUseCase;

	@PostMapping ("/change-request")
	public ResponseEntity<String> requestEmailChange (@RequestParam String curEmail, @RequestParam String newEmail) {
		try
		{
			changeEmailRequestUseCase.requestEmailChange(curEmail, newEmail);
			return ResponseEntity.ok("OTP sent to your new email");
		} catch (IllegalArgumentException e)
		{
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping ("/verify")
	public ResponseEntity<String> verifyAndChangeEmail (@RequestParam String curEmail, @RequestParam String otp,
	                                                    @RequestParam String newEmail) {
		try
		{
			verifyAndChangeEmailUseCase.verifyAndChangeEmail(curEmail, otp, newEmail);
			return ResponseEntity.ok("Email has been changed successfully");
		} catch (IllegalArgumentException e)
		{
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
