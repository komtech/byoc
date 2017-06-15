package com.starbucks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starbucks.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public Customer findByCustID(Long id);
	public Customer findByCustName(String custName);
	
}
