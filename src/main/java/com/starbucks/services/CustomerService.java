package com.starbucks.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.starbucks.models.Customer;
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
}
