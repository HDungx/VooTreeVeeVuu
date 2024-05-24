package com.VooTreeVeeVuu.repository;

import com.VooTreeVeeVuu.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}