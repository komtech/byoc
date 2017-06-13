package com.starbucks.services;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.starbucks.models.Customer;
import com.starbucks.models.CustomerEnrollFact;
import com.starbucks.models.Promo;
import com.starbucks.repositories.CustomerEnrollFactRepository;

@Transactional
@Path("customerEnroll") //http://localhost:8080/byoc/customerEnroll
public class CustomerEnrollService {

	ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("META-INF/application-context.xml");
	CustomerEnrollFactRepository repository=context.getBean(CustomerEnrollFactRepository.class);

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;


	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<CustomerEnrollFact> getAllPromo()
	{	
		List<CustomerEnrollFact> customerFact=repository.findAll();
		return customerFact; 
	}

	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("{promoID}") //http://localhost:8080/byoc/customerEnroll/1234
	public CustomerEnrollFact getPromo(@PathParam ("promoID") Long promoID)
	{	
		CustomerEnrollFact customerFact=repository.findByPromoID(promoID);
		return customerFact; 
	}

	@POST
	@Transactional
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON}) //http://byoc/customerEnroll?customerID=x&promoID=y
	public CustomerEnrollFact customerEnrollment(@QueryParam("customerID") long param1,
			@QueryParam("promoID") long param2)
	{
		//Getting the customer and promo
		CustomerService cs = new CustomerService();
		Customer cust = cs.getCustomer(param1);

		PromoService ps = new PromoService();
		Promo promo = ps.getPromo(param2);

		if(promo == null || cust == null)
		{
			//throw some error
		}

		CustomerEnrollFact fact = new CustomerEnrollFact();
		fact.setCustID(param1);
		fact.setPromoID(param2);
		//fact.setPromoEnrollStatus("true");
		fact.setPromoGoal(promo.getPromoGoal());
		fact.setPromoName(promo.getPromoName());
		fact.setPromoProgres((long) 1);
		fact.setPromoStarReward(promo.getPromoStarReward());
		fact.setPromoStartDate(promo.getPromoStartDate());
		fact.setCustEnrollDate(promo.getPromoStartDate());
		fact.setPromoEndDate(promo.getPromoEndDate());

		repository.save(fact);
		return fact;
	}


	public void customerEnrollmentRequestPost(String customerName, long promoID)
	{
		//Getting the customer and promo
		CustomerService cs = new CustomerService();
		Customer cust = cs.getCustomerName(customerName);

		PromoService ps = new PromoService();
		Promo promo = ps.getPromo(promoID);

		if(promo == null || cust == null)
		{
			//throw some error
		}

		CustomerEnrollFact fact = new CustomerEnrollFact();
		fact.setCustID(cust.getCustID());
		fact.setPromoID(promoID);
		fact.setPromoEnrollStatus("true");
		fact.setPromoGoal(promo.getPromoGoal());
		fact.setPromoName(promo.getPromoName());
		fact.setPromoProgres((long) 1);
		fact.setPromoStarReward(promo.getPromoStarReward());
		fact.setPromoStartDate(promo.getPromoStartDate());
		fact.setCustEnrollDate(promo.getPromoStartDate());
		fact.setPromoEndDate(promo.getPromoEndDate());

		repository.save(fact);
	}
	

	public CustomerEnrollFact getPromoByCustomerID(Long customerID)
	{	
		CustomerEnrollFact customerFact=repository.findByCustID(customerID);
		return customerFact; 
	}
	
}
