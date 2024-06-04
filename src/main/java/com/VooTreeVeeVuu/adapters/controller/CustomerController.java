package com.VooTreeVeeVuu.adapters.controller;

import com.VooTreeVeeVuu.domain.entity.Customer;
import com.VooTreeVeeVuu.services.CustomerServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin ("*")
@RestController
@RequestMapping ("/api/customers")
public class CustomerController {
	@Autowired
	CustomerServ customerServ;

//	@GetMapping ()
//	public Page<Customer> getAllCustomers (@RequestParam (defaultValue = "0") int page,
//	                                       @RequestParam (defaultValue = "10") int size,
//	                                       @RequestParam (defaultValue = "customerId") String sortBy,
//	                                       @RequestParam (defaultValue = "asc") String dir) {
//		Sort sort = dir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
//		Pageable pageable = PageRequest.of(page, size, sort);
//		return customerServ.getAll(pageable);
//	}

	@GetMapping ()
	public ResponseEntity<List<Customer>> getAllCustomers () {
		return new ResponseEntity<>(customerServ.getAll(), HttpStatus.OK);
	}

	@GetMapping ("/{id}")
	public ResponseEntity<Customer> getCustomerById (@PathVariable String id) {
		return customerServ.findById(id).map(customer -> new ResponseEntity<>(customer, HttpStatus.OK)).orElse(
				new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public ResponseEntity<Customer> createCustomer (@RequestBody Customer customer) {
		return new ResponseEntity<>(customerServ.save(customer), HttpStatus.CREATED);
	}

	@PutMapping ("/update/{id}")
	public ResponseEntity<Customer> updateCustomer (@PathVariable String id, @RequestBody Customer customer) {
		return customerServ.findById(id).map(cus -> {
			cus.setFirstName(customer.getFirstName());
			cus.setLastName(customer.getLastName());
			cus.setEmail(customer.getEmail());
			cus.setPhoneNum(customer.getPhoneNum());
			cus.setGender(customer.getGender());
			cus.setAge(customer.getAge());
			cus.setStatus(customer.isStatus());
			cus.setAccount(customer.getAccount());
			return new ResponseEntity<>(customerServ.save(cus), HttpStatus.OK);
		}).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping ("/delete/{id}")
	public ResponseEntity<Void> deleteCustomer (@PathVariable String id) {
		return customerServ.findById(id).map(cus -> {
			customerServ.deleteById(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
