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
public class ChangePhoneNumRequestUseCase {
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private OTPRepository otpRepository;

	@Autowired
	private EmailService emailService;

	public void requestPhoneNumChange (String email, String curPhone, String newPhone) {
		Account account = accountRepository.findByEmail(email);
		if (account == null)
		{
			throw new IllegalArgumentException("User not found with the provided email.");
		}
		if (accountRepository.findByPhoneNum(curPhone) == null)
		{
			throw new IllegalArgumentException("User not found with the provided phone num.");
		}
		if (accountRepository.findByPhoneNum(newPhone) != null)
		{
			throw new IllegalArgumentException("New phone number is currently in use");
		}

		// Remove existing OTP for the new phone number if any
		otpRepository.deleteByNewEmailAndNewPhoneNum(email, newPhone);

		// Generate new OTP
		String otp = generateOTP();
		OTP otpToken = new OTP();
		otpToken.setOtp(otp);
		otpToken.setGeneratedTime(LocalDateTime.now());
		otpToken.setAccount(account);
		otpToken.setNewEmail(email);
		otpToken.setNewPhoneNum(newPhone);
		otpRepository.save(otpToken);

		emailService.sendOTP(email, otp);
	}

	private String generateOTP () {
		return String.valueOf((int) (Math.random() * 900000) + 100000);
	}
}
