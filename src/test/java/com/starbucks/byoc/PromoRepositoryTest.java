package com.starbucks.byoc;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.starbucks.repositories.PromoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
public class PromoRepositoryTest {
	
	@Autowired
	PromoRepository repository;
	
	@Test
	public void getAllPromosTest() {
		assertNotNull(repository.findAll());
	}
	

}
