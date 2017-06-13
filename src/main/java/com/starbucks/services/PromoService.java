package com.starbucks.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.starbucks.models.Promo;
import com.starbucks.repositories.PromoRepository;

@Path("promos") //http://localhost:8080/byoc/promos
public class PromoService {
	
	ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("META-INF/application-context.xml");
	PromoRepository repository=context.getBean(PromoRepository.class);
   
	@GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getAllPromos()
	{	
    	List<Promo> promo=repository.findAll();        
     
        if(promo.size()==0) 
    	{
    		return Response.status(Status.NOT_FOUND).build();
    		
    	}
        return Response.ok().entity(new GenericEntity<List<Promo>>(promo) {}).build();
	}

}
