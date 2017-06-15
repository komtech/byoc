package com.starbucks.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.starbucks.models.Customer;
import com.starbucks.models.CustomerEnrollFact;
import com.starbucks.models.Promo;
import com.starbucks.repositories.CustomerRepository;
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

	public List<Promo> getAllPromo()
	{	
    	List<Promo> promos=repository.findAll();
        return promos; 
	}
	
	@GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("{customerId}") //http://localhost:8080/byoc/customers/1234
	public Promo getPromo(@PathParam ("customerId") Long promoID)
	{	
    	Promo promo=repository.findByPromoID(promoID);
        return promo; 

	}
	
	@GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("/customer/{customerName}") //http://localhost:8080/byoc/customers/1234
	public Promo getCustomerPromo(@PathParam ("customerName") String customerName)
	{	
		CustomerService cs = new CustomerService();
		CustomerEnrollService CES = new CustomerEnrollService();
    	Customer customer = cs.getCustomerName(customerName);
    	Long custID = customer.getCustID();
    	
    	// user the custom ID to find the promo the in the CES.
    	
    	CustomerEnrollFact CEF = new CustomerEnrollFact();
    	CEF = CES.getPromoByCustomerID(custID);
    	
    	Promo promo = this.getPromo(CEF.getPromoID());
 
        return promo; 
	}	
}
