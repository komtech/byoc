package com.starbucks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starbucks.models.CustomerEnrollFact;

public interface CustomerEnrollFactRepository extends JpaRepository<CustomerEnrollFact, Long> {
	
	public CustomerEnrollFact findByPromoID(Long id);
	public CustomerEnrollFact findByCustID(Long id);
	public CustomerEnrollFact findByCustIDAndPromoEnrollStatus(Long id, String str);
	
	
}
