package com.starbucks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starbucks.models.Customer;
import com.starbucks.models.Promo;

public interface PromoRepository extends JpaRepository<Promo, Long> {

	public Promo findByPromoID(Long id);
	
}
