package com.starbucks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starbucks.models.CustomerEnrollFact;

public interface CustEnrollFactRepository extends JpaRepository<CustomerEnrollFact, Long> {

	public CustomerEnrollFact findFirstByCustIDAndPromoEnrollStatus(Long custID, String promoEnrollStatus);
}
