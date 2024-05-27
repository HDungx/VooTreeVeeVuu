package com.VooTreeVeeVuu.controller;

import com.VooTreeVeeVuu.entity.Account;
import com.VooTreeVeeVuu.servicesImp.AccountServImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin ("*")
@RestController
@RequestMapping ("/api/accounts")
public class AccountController {
	@Autowired
	AccountServImp accountServImp;

	@GetMapping ()
	public ResponseEntity<List<Account>> getAllAccount () {
		return new ResponseEntity<>(accountServImp.getAll(), HttpStatus.OK);
	}

	@GetMapping ("{username}")
	public ResponseEntity<Account> getAccountByUsername (@PathVariable String username) {
		return accountServImp.getByUsername(username).map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElse(
				new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public ResponseEntity<Account> createAccount (@RequestBody Account account) {
		return new ResponseEntity<>(accountServImp.save(account), HttpStatus.CREATED);
	}

	@PutMapping ("/{username}")
	public ResponseEntity<Account> updateAccount (@RequestBody Account account, @PathVariable String username) {
		return accountServImp.getByUsername(username).map(acc -> {
			acc.setPassword(account.getPassword());
			acc.setRole(account.getRole());
			acc.setEmail(account.getEmail());
			return new ResponseEntity<>(accountServImp.save(acc), HttpStatus.OK);
		}).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping ("/{username}")
	public ResponseEntity<Void> deleteAccount (@PathVariable String username) {
		return accountServImp.getByUsername(username).map(account -> {
			accountServImp.delete(username);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
