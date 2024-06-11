package com.VooTreeVeeVuu.usecase.AccountUseCase;

import com.VooTreeVeeVuu.domain.entity.Account;
import com.VooTreeVeeVuu.domain.entity.OTP;
import com.VooTreeVeeVuu.domain.repository.AccountRepository;
import com.VooTreeVeeVuu.domain.repository.OTPRepository;
import com.VooTreeVeeVuu.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ChangeEmailRequestUseCase {
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private OTPRepository otpRepository;

	@Autowired
	private EmailService emailService;

	public void requestEmailChange (String curEmail, String newEmail) {
		Account account = accountRepository.findByEmail(curEmail);

		if (account == null)
		{
			throw new IllegalArgumentException("Current email not found");
		}
		if (accountRepository.findByEmail(newEmail) != null)
		{
			throw new IllegalArgumentException("New email is already in use");
		}

		// Remove existing OTP for the new email if any
		otpRepository.deleteByAccountAndNewEmail(account, newEmail);

		// Generate new OTP
		String otp = generateOTP();
		OTP otpToken = new OTP();
		otpToken.setOtp(otp);
		otpToken.setGeneratedTime(LocalDateTime.now());
		otpToken.setAccount(account);
		otpToken.setNewEmail(newEmail);
		otpRepository.save(otpToken);

		emailService.sendOTP(newEmail, otp);
	}

	private String generateOTP () {
		return String.valueOf((int) (Math.random() * 900000) + 100000);
	}
}
