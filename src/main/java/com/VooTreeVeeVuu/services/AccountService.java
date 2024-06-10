package com.VooTreeVeeVuu.services;

import com.VooTreeVeeVuu.adapters.repository.JpaRoleRepository;
import com.VooTreeVeeVuu.domain.entity.Account;
import com.VooTreeVeeVuu.domain.entity.OTP;
import com.VooTreeVeeVuu.domain.entity.Role;
import com.VooTreeVeeVuu.domain.repository.AccountRepository;
import com.VooTreeVeeVuu.domain.repository.OTPRepository;
import com.VooTreeVeeVuu.domain.repository.RoleRepository;
import com.VooTreeVeeVuu.domain.utils.RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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

	@Autowired
	private JpaRoleRepository roleRepository;

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
		if (passwordEncoder.matches(account.getPassword(), newPassword))
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
