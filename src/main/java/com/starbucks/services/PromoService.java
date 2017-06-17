package com.starbucks.services;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
import com.starbucks.models.PromoReq;
import com.starbucks.repositories.CustEnrollFactRepository;
import com.starbucks.repositories.CustomerRepository;
import com.starbucks.repositories.PromoRepository;

@Path("promos") //http://localhost:8080/byoc/promos
public class PromoService {
	
	ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("META-INF/application-context.xml");
	PromoRepository promoRepository=context.getBean(PromoRepository.class);
	CustEnrollFactRepository custEnrollFactRepository = context.getBean(CustEnrollFactRepository.class);
	CustomerRepository customerRepository = context.getBean(CustomerRepository.class);
   
	@GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	
	public Response getAllPromos()
	{	
    	List<Promo> promo=promoRepository.findAll();        
     
        if(promo.size()==0) 
    	{
    		return Response.status(Status.NOT_FOUND).build();
    		
    	}
        
        return Response.ok().entity(new GenericEntity<List<Promo>>(promo) {}).build();
	}

	
	@GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("{cust_name}") // http://localhost:8080/byoc/promos/sopheara
	public Response getPromo(@PathParam("cust_name") String custName)
	{	
		// Get customer
		Customer customer = customerRepository.findByCustName(custName);
		// Get a Customer with 'Enrolled' status from CustomerEnrollFact
		
		CustomerEnrollFact customerEnrollFact = custEnrollFactRepository.findFirstByCustIDAndPromoEnrollStatus(customer.getCustID(),
						"ENROLLED");
		if(customerEnrollFact==null)
		{
			return Response.status(Status.NOT_FOUND).build();
		}
    	
        return Response.ok().entity(customerEnrollFact).build(); 

	}
	
	@POST // http://localhost:8080/byoc/orders
	@Consumes(MediaType.APPLICATION_XML)
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response enrollPromo(PromoReq promoReq) {
		
			
		// Get customer
		Customer customer = customerRepository.findByCustName(promoReq.getCustName());
		Promo promo=promoRepository.findByPromoName(promoReq.getPromoName());
		
		// Get a Customer with 'Enrolled' status from CustomerEnrollFact
		CustomerEnrollFact customerEnrollFact = custEnrollFactRepository.findFirstByCustIDAndPromoEnrollStatus(customer.getCustID(),
						"ENROLLED");
		if (customerEnrollFact == null) {
			customerEnrollFact=new CustomerEnrollFact();
			customerEnrollFact.setPromoID(promo.getPromoID());
			customerEnrollFact.setCustID(customer.getCustID());
			customerEnrollFact.setPromoName(promo.getPromoName());
			customerEnrollFact.setPromoGoal(promo.getPromoGoal());
			customerEnrollFact.setPromoStarReward(promo.getPromoStarReward());
			customerEnrollFact.setPromoEnrollStatus("ENROLLED");
			customerEnrollFact.setCustEnrollDateTime(new Date());
			customerEnrollFact.setPromoEndDate(promo.getPromoEndDate());
			customerEnrollFact.setPromoProgress(0L);			
		}
		
		custEnrollFactRepository.save(customerEnrollFact);
		
		return Response.ok().build();
	

	}

	

}
