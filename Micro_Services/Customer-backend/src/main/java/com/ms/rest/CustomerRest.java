package com.ms.rest;

import java.util.List;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.ms.bo.CustomerBO;

@Named
@Path("/")
public class CustomerRest {

	@GET
	@ExceptionHandler({RuntimeException.class})
	@Produces(MediaType.APPLICATION_JSON)
		public ModelAndView getCustomers() {
		
		ModelAndView mv = new ModelAndView();
		
		CustomerBO customerBO = new CustomerBO();
		List<Customer> customers = customerBO.getCustomer();
		
		mv.getModel().put("customers", customers);
		
		return mv;
	}
	
	@GET
	@Path("customer")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomer(@QueryParam("id") long id) {
		
		CustomerBO customerBO = new CustomerBO();
		List<Customer> customers = customerBO.getCustomer();
		
		Customer cli = null;
		for (Customer c : customers) {
			if (c.getId() == id)
			cli = c;
		}
		return cli;
	}

}

