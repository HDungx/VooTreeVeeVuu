package com.VooTreeVeeVuu.servicesImp;

import com.VooTreeVeeVuu.entity.Account;
import com.VooTreeVeeVuu.entity.Customer;
import com.VooTreeVeeVuu.repository.CustomerRepository;
import com.VooTreeVeeVuu.services.CustomerServ;
import com.VooTreeVeeVuu.utils.AlphaNumComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServImp implements CustomerServ {
	@Autowired
	CustomerRepository customerRepository;

//	@Override
//	public Page<Customer> getAll (Pageable pageable) {
//		List<Customer> list = customerRepository.findAll();
//		List<Customer> sortedList = list.stream().sorted(
//				(p1, p2) -> new AlphaNumComparator().compare(p1.getCustomer_Id(), p2.getCustomer_Id())).toList();
//		int total = sortedList.size();
//		List<Customer> pageProj = sortedList.stream().skip(
//				(long) pageable.getPageNumber() * pageable.getPageSize()).limit(pageable.getPageSize()).toList();
//		return new PageImpl<>(pageProj, pageable, total);
//	}


	@Override
	public Page<Customer> getAll (Pageable pageable) {
		return customerRepository.findAll(pageable);
	}

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
