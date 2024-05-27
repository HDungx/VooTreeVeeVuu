package com.VooTreeVeeVuu.services;

import com.VooTreeVeeVuu.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerServ {
	public List<Customer> getAll ();

	public Optional<Customer> findById (String id);

	public Customer save (Customer customer);

	public void deleteById (String id);
}
