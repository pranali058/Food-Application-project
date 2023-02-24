package com.food.foodSpringApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.food.foodSpringApp.dao.CustomerDao;
import com.food.foodSpringApp.dto.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerDao customerDao;

	@PostMapping
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerDao.saveCustomer(customer);
	}
	@GetMapping("/{id}")
	public Customer findCustomer(@PathVariable int id) {
		Optional<Customer>c=customerDao.getCustomerById(id);
		if (c.isPresent()) {
			return c.get();
		} else {
           return null;
		}
	}

	
	  @GetMapping public List<Customer> findAllCustomer() { 
		  return customerDao.getAllCustomer(); }
	 
	@PutMapping
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerDao.updateCustomer(customer);
	}
	@DeleteMapping
	public String delteCustomer(@RequestParam int id) {
		Optional<Customer>c=customerDao.getCustomerById(id);
		if (c.isPresent()) {
			customerDao.deleteCustomer(id);
			return "data is deleted";
		} else {
            return "data is not found";
		}
	}
	
}
