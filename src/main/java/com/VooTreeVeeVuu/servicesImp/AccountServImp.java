package com.VooTreeVeeVuu.servicesImp;

import com.VooTreeVeeVuu.entity.Account;
import com.VooTreeVeeVuu.entity.Staff;
import com.VooTreeVeeVuu.repository.AccountRepository;
import com.VooTreeVeeVuu.services.AccountServ;
import com.VooTreeVeeVuu.utils.AlphaNumComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServImp implements AccountServ {
	@Autowired
	AccountRepository accountRepository;

//	@Override
//	public Page<Account> getAll (Pageable pageable) {
//		List<Account> list = accountRepository.findAll();
//		List<Account> sortedList = list.stream().sorted(
//				(p1, p2) -> new AlphaNumComparator().compare(p1.getUsername(), p2.getUsername())).toList();
//		int total = sortedList.size();
//		List<Account> pageProj = sortedList.stream().skip(
//				(long) pageable.getPageNumber() * pageable.getPageSize()).limit(pageable.getPageSize()).toList();
//		return new PageImpl<>(pageProj, pageable, total);
//	}

	@Override
	public Page<Account> getAll (Pageable pageable) {
		return accountRepository.findAll(pageable);
	}

	@Override
	public Optional<Account> getByUsername (String username) {
		return accountRepository.findById(username);
	}

	@Override
	public Account save (Account account) {
		return accountRepository.save(account);
	}

	@Override
	public void delete (String username) {
		accountRepository.deleteById(username);
	}
}
