package com.VooTreeVeeVuu.repository;

import com.VooTreeVeeVuu.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}