package com.VooTreeVeeVuu.usecase.AccountUseCase;

import com.VooTreeVeeVuu.domain.entity.Account;
import com.VooTreeVeeVuu.domain.entity.OTP;
import com.VooTreeVeeVuu.domain.repository.AccountRepository;
import com.VooTreeVeeVuu.domain.repository.OTPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VerifyAndChangeEmailUseCase {
	private static final long OTP_EXPIRATION_MINUTES = 2;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private OTPRepository otpRepository;

	public void verifyAndChangeEmail (String curEmail, String otp, String newEmail) {
		Account account = accountRepository.findByEmail(curEmail);
		if (account == null)
		{
			throw new IllegalArgumentException("Current email not found");
		}
		OTP otpToken = otpRepository.findByAccountAndNewEmail(account, newEmail);
		if (otpToken == null)
		{
			throw new IllegalArgumentException("OTP not generate for this user or new email");
		}
		if (isExpired(otpToken))
		{
			//delete expired otp
			otpRepository.delete(otpToken);
			throw new IllegalArgumentException("OTP has expired");
		}
		if (!otp.equals(otpToken.getOtp()))
		{
			throw new IllegalArgumentException("Invalid OTP");
		}

		//Update mail
		account.setEmail(newEmail);
		accountRepository.save(account);
		otpRepository.delete(otpToken);
	}

	public boolean isExpired (OTP otp) {
		return otp.getGeneratedTime().plusMinutes(OTP_EXPIRATION_MINUTES).isBefore(LocalDateTime.now());
	}
}
