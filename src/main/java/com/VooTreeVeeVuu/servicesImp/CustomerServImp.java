package com.VooTreeVeeVuu.servicesImp;

import com.VooTreeVeeVuu.entity.Customer;
import com.VooTreeVeeVuu.repository.CustomerRepository;
import com.VooTreeVeeVuu.services.CustomerServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServImp implements CustomerServ {
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> getAll () {
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> findById (String id) {
		return customerRepository.findById(id);
	}

	@Override
	public Customer save (Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void deleteById (String id) {
		customerRepository.deleteById(id);
	}
}
