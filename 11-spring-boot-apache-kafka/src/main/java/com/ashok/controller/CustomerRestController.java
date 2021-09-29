package com.ashok.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.model.Customer;
import com.ashok.service.CustomerService;

/**
 * This class is used to handle user requests
 * 
 * @author Ashok
 *
 */
@RestController
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	/**
	 * This method is used to Customer records in post request
	 * @param customers
	 * @return
	 */
	@PostMapping(value = "/addCustomer", 
			consumes = { 
					MediaType.APPLICATION_JSON, 
					MediaType.APPLICATION_XML 
			}
	)
	public String addCustomer(@RequestBody List<Customer> customers) {
		return customerService.add(customers);
	}
}
