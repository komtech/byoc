package com.starbucks.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.starbucks.models.Customer;
import com.starbucks.models.CustomerEnrollFact;
import com.starbucks.models.Promo;
import com.starbucks.repositories.CustomerRepository;

@Path("customers") //http://localhost:8080/byoc/customers
public class CustomerService {
	
	ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("META-INF/application-context.xml");
	CustomerRepository repository=context.getBean(CustomerRepository.class);
   

	
	@GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("{cust_name}") //http://localhost:8080/byoc/customers/sopheara
	public Response getCustomer(@PathParam ("cust_name") String custName)
	{	
		if(custName ==null || custName.isEmpty())
		{
			return Response.status(Status.BAD_REQUEST).build();
		}		
		
    	Customer customer=repository.findByCustName(custName);
    	
    	if(customer==null) 
    	{
    		return Response.status(Status.NOT_FOUND).build();
    		
    	}
    	
        return Response.ok().entity(customer).build();
	}
	
	/*@GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Customer> getAllCustomers()
	{	
    	List<Customer> customers=repository.findAll();
        return customers; 
	
	
	
	@GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("{customerId}") //http://localhost:8080/byoc/customers/1234
	public Customer getCustomer(@PathParam ("customerId") Long customerId)
	{	
    	Customer customer=repository.findByCustID(customerId);
        return customer; 
	}
	}*/
	
	public Customer getCustomer(@PathParam ("customerId") Long customerId)
	{	
    	Customer customer=repository.findByCustID(customerId);
        return customer; 
	}
	
	
	@POST
	@Consumes({MediaType.APPLICATION_XML})
	@Path("/{customerName}/enroll") //http://localhost:8080/byoc/customers/1234
	public Response enrollCustomer(@PathParam ("customerName") String customerName,
			 Promo promo)
	{	
    	CustomerEnrollService CES = new CustomerEnrollService();
    	CustomerEnrollFact fact = CES.customerEnrollmentRequestPost(customerName, promo.getPromoID());
    	return Response.ok().build();//.entity(fact).build();
	}
	
	public Customer getCustomerName(String customerName)
	{	
    	Customer customer=repository.findByCustName(customerName);
        return customer; 
	}
}
