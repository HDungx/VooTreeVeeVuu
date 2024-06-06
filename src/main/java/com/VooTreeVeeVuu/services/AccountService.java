package com.VooTreeVeeVuu.services;

import com.VooTreeVeeVuu.domain.entity.Account;
import com.VooTreeVeeVuu.domain.entity.OTP;
import com.VooTreeVeeVuu.domain.repository.AccountRepository;
import com.VooTreeVeeVuu.domain.repository.OTPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AccountService {
	private static final long OTP_EXPIRATION_MINUTES = 1;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private OTPRepository otpRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private EmailService emailService;

	private String generateOTP () {
		return String.valueOf((int) (Math.random() * 900000) + 100000);
	}

	public void generateAndSendOTP (String email) {
		Account account = accountRepository.findByEmail(email);
		if (account == null)
		{
			throw new IllegalArgumentException("Invalid email");
		}

		//remove existed otp in account
		otpRepository.deleteByAccount(account);

		//generate new otp
		String otp = generateOTP();
		OTP otpToken = new OTP();
		otpToken.setOtp(otp);
		otpToken.setGeneratedTime(LocalDateTime.now());
		otpToken.setAccount(account);
		otpRepository.save(otpToken);

		emailService.sendOTP(email, otp);
	}

	public boolean isExpired (OTP otp) {
		return otp.getGeneratedTime().plusMinutes(OTP_EXPIRATION_MINUTES).isBefore(LocalDateTime.now());
	}

	public void resetPassword (String email, String otp, String newPassword) {
		Account account = accountRepository.findByEmail(email);
		if (account == null)
		{
			throw new IllegalArgumentException("Invalid email");
		}
		OTP otpToken = otpRepository.findByAccount(account);
		if (otpToken == null)
		{
			throw new IllegalArgumentException("No OTP for this account");
		}
		if (isExpired(otpToken))
		{
			otpRepository.delete(otpToken);
			throw new IllegalArgumentException("OTP has expired");
		}
		if (!otp.equals(otpToken.getOtp()))
		{
			throw new IllegalArgumentException("Invalid OTP");
		}
		//change password
		if (account.getPassword().equals(newPassword))
		{
			System.out.println(account.getPassword());
			throw new IllegalArgumentException("Must be different from old password");
		}
		account.setPassword(passwordEncoder.encode(newPassword));
		accountRepository.save(account);
		//clean used otp
		otpRepository.delete(otpToken);
	}
}
