package com.starbucks.services;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.starbucks.models.Transaction;
import com.starbucks.models.TransactionReq;
import com.starbucks.models.TransactionResp;
import com.starbucks.repositories.CustEnrollFactRepository;
import com.starbucks.repositories.CustomerRepository;
import com.starbucks.repositories.TransactionRepository;

@Path("orders") // http://localhost:8080/byoc/orders
public class TransactionService {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/application-context.xml");

	CustomerRepository customerRepository = context.getBean(CustomerRepository.class);
	TransactionRepository tranRepository = context.getBean(TransactionRepository.class);
	CustEnrollFactRepository custEnrollFactRepository = context.getBean(CustEnrollFactRepository.class);

	final double STAR_RATE = 2.00;
	final double TREE_RATE = 2.00;
	final double CARBON_RATE = 2.00;
	final Long BONUS_STARS_AWARDED = 60L;
//
//	/*
//	 * @GET
//	 * 
//	 * @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
//	 * 
//	 * @Path("{cust_name}") //http://localhost:8080/byoc/customers/sopheara
//	 * public List<Transaction> getCustomer(@PathParam ("cust_name") String
//	 * custName) { //test check in comment List<Transaction>
//	 * trans=repository.findByCustomerCustName(custName); return trans; }
//	 */
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("{cust_name}") // http://localhost:8080/byoc/orders/sopheara
	public Response getCustomer(@PathParam("cust_name") String custName) {
		if (custName == null || custName.isEmpty()) {
			return Response.status(Status.BAD_REQUEST).build();
		}

		List<Transaction> trans = tranRepository.findTop5ByCustomerCustNameOrderByTranIDAsc(custName);

		if (trans.size() == 0) {
			return Response.status(Status.NOT_FOUND).build();

		}
		List<TransactionResp> transResp = new ArrayList<TransactionResp>();

		for (Transaction t : trans) {
			TransactionResp tr = new TransactionResp();
			tr.setTranID(t.getTranID());
			tr.setCustID(t.getCustomer().getCustID());
			tr.setCustName(t.getCustomer().getCustName());
			tr.setItemType(t.getItemType());
			tr.setOrderItem(t.getOrderItem());
			tr.setStars(t.getStars());
			tr.setTotalTranAmount(t.getTotalTranAmount());
			tr.setTranDateTime(t.getTranDateTime());
			transResp.add(tr);

		}
		return Response.ok().entity(new GenericEntity<List<TransactionResp>>(transResp) {
		}).build();
	}

	@POST // http://localhost:8080/byoc/orders
	@Consumes(MediaType.APPLICATION_XML)
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response orderDrinkParams(TransactionReq transactionReq) {
			
	
		String custName = transactionReq.getCustName();
		Long TotalStarsEarned = transactionReq.getTotalTranAmount().multiply(new BigDecimal(STAR_RATE))
				.setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
	
		Date today = new Date();

		// Get customer
		Customer customer = customerRepository.findByCustName(custName);

		// debug
		System.out.println(customer);

		// Save the "Personal Cup Discount" transaction	
		Transaction transaction = new Transaction();
		transaction.setTranDateTime(today);
		transaction.setStars(TotalStarsEarned);
		transaction.setItemType(transactionReq.getItemType());
		transaction.setOrderItem(transactionReq.getOrderItem());
		transaction.setTotalTranAmount(transactionReq.getTotalTranAmount());
		// Update customer stars
		customer.setCustStarPurse(customer.getCustStarPurse() + TotalStarsEarned);
		transaction.setCustomer(customer);	
		
		tranRepository.save(transaction);
		
		// debug
		
		System.out.println(transaction);

		// Get a Customer with 'Enrolled' status from CustomerEnrollFact
		CustomerEnrollFact customerEnrollFact = custEnrollFactRepository.findFirstByCustIDAndPromoEnrollStatus(customer.getCustID(),
				"ENROLLED");

		// debug
		System.out.println(customerEnrollFact);

		if (customerEnrollFact != null) {
			// Check if today is before or equal Promo End Date
			if (today.compareTo(customerEnrollFact.getPromoEndDate()) <= 0) {
				customerEnrollFact.setPromoProgress(customerEnrollFact.getPromoProgress() + 1);
			} else {
				// If Promo End Date Time is in the past, we end the promo
				customerEnrollFact.setPromoEnrollStatus("ENDED");
			}

			// Update Promo Enroll Status if Promo Goal equal Promo Progress
			if (customerEnrollFact.getPromoGoal().equals(customerEnrollFact.getPromoProgress())
					&& customerEnrollFact.getPromoEnrollStatus().equals("ENROLLED")) {
				customerEnrollFact.setPromoEnrollStatus("WON");

				// Insert a new transaction for earn reward stars amount into
				// Transaction table("BONUS STARS AWARDED")
				Transaction starsEarnedTrans = new Transaction();				
				starsEarnedTrans.setItemType("BONUS STARS AWARDED");
				starsEarnedTrans.setStars(BONUS_STARS_AWARDED);
				starsEarnedTrans.setTotalTranAmount(new BigDecimal(0));
				starsEarnedTrans.setTranDateTime(today);
				// Update customer stars
				customer.setCustStarPurse(customer.getCustStarPurse() + BONUS_STARS_AWARDED);
				starsEarnedTrans.setCustomer(customer);

				// save the bonus star earn transaction
				tranRepository.save(starsEarnedTrans);

			}

			// debug
			System.out.println(customerEnrollFact);

			// Save Custome Enroll Fact
			custEnrollFactRepository.save(customerEnrollFact);
		}
		customer.setCarbonReduction(customer.getCarbonReduction().add(new BigDecimal(CARBON_RATE)));
		customer.setTreesPreserved(customer.getTreesPreserved().add(new BigDecimal(TREE_RATE)));
		customer.setReuseCupPurse(customer.getReuseCupPurse() + 1);

		customerRepository.save(customer);
		return Response.ok().entity(customer).build();

	}

	// @POST // http://localhost:8080/byoc/order
	// @Consumes(MediaType.APPLICATION_XML)
	// @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	// public Customer orderDrinkParams(Customer customer)
	// {
	// System.out.println(customer.getCustID());
	// System.out.println(customer.getCustName());
	// System.out.println(customer.getCustStarPurse());
	//
	// return customer;
	//
	// }

}