package com.VooTreeVeeVuu.usecase.AccountUseCase;

import com.VooTreeVeeVuu.domain.entity.Account;
import com.VooTreeVeeVuu.domain.entity.OTP;
import com.VooTreeVeeVuu.domain.repository.AccountRepository;
import com.VooTreeVeeVuu.domain.repository.OTPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VerifyAndChangePhoneNumUseCase {
	private static final long OTP_EXPIRATION_MINUTES = 1;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private OTPRepository otpRepository;

	public void verifyAndChangePhoneNum (String email, String otp, String newPhoneNum) {
		Account account = accountRepository.findByEmail(email);
		if (account == null)
		{
			throw new IllegalArgumentException("User not found");
		}

		OTP otpToken = otpRepository.findByNewEmailAndNewPhoneNum(email, newPhoneNum);
		if (otpToken == null)
		{
			throw new IllegalArgumentException("OTP not generated for this user or new phone number");
		}
		if (isExpired(otpToken)) {
			otpRepository.delete(otpToken); // Clean up expired OTP
			throw new IllegalArgumentException("OTP has expired");
		}
		if (!otp.equals(otpToken.getOtp())) {
			throw new IllegalArgumentException("Invalid OTP");
		}

		// Update the phone number
		account.setPhoneNum(newPhoneNum);
		accountRepository.save(account);
		otpRepository.delete(otpToken); // Clean up used OTP
	}

	public boolean isExpired (OTP otp) {
		return otp.getGeneratedTime().plusMinutes(OTP_EXPIRATION_MINUTES).isBefore(LocalDateTime.now());
	}
}
