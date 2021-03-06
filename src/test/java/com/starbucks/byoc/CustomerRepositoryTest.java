package com.starbucks.byoc;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.starbucks.models.Customer;
import com.starbucks.repositories.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
public class CustomerRepositoryTest {

	@Autowired
	CustomerRepository repository;
	
	@Test
	public void getAllCustomerTest() {
		assertNotNull(repository.findAll());
	}
	
	@Test
	public void getFirstCustomerTest() {
		// test check in e

		Customer customer=repository.findByCustName("Sopheara");
		String expected="Sopheara";	
		assertTrue(expected.equalsIgnoreCase(customer.getCustName()));	


	}

}
