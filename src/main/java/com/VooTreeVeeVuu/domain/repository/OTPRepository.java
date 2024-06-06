package com.VooTreeVeeVuu.domain.repository;

import com.VooTreeVeeVuu.domain.entity.Account;
import com.VooTreeVeeVuu.domain.entity.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface OTPRepository extends JpaRepository<OTP, Long> {
	OTP findByAccount (Account account);

	@Transactional
	void deleteByAccount (Account account);
}