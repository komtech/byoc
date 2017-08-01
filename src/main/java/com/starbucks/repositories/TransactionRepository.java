package com.starbucks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starbucks.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	public List<Transaction> findTop5ByCustomerCustNameOrderByTranIDAsc(String customerName); 
}
