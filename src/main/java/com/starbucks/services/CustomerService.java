package com.starbucks.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.starbucks.models.Customer;
import com.starbucks.repositories.CustomerRepository;

@Path("customers") //http://localhost:8080/byoc/customers
public class CustomerService {
	
	ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("META-INF/application-context.xml");
	CustomerRepository repository=context.getBean(CustomerRepository.class);
   
	@GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Customer> getAllCustomers()
	{	
    	List<Customer> customers=repository.findAll();
        return customers; 
	}
	
	@GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("{customerId}") //http://localhost:8080/byoc/customers/1234
	public Customer getCustomer(@PathParam ("customerId") Long customerId)
	{	
    	Customer customer=repository.findByCustID(customerId);
        return customer; 
	}
}
