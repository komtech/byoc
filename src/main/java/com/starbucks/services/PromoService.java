package com.starbucks.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.starbucks.models.Promo;
import com.starbucks.repositories.PromoRepository;

@Path("promos") //http://localhost:8080/byoc/promos
public class PromoService {
	
	ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("META-INF/application-context.xml");
	PromoRepository repository=context.getBean(PromoRepository.class);
   
	@GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Promo> getAllPromos()
	{	
    	List<Promo> promo=repository.findAll();
        return promo; 
	}

}
