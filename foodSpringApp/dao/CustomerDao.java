package com.food.foodSpringApp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food.foodSpringApp.dto.Customer;
import com.food.foodSpringApp.repository.CustomerRepo;

@Repository
public class CustomerDao {
  @Autowired
  CustomerRepo customerRepo;
  
  public Customer saveCustomer(Customer customer) {
	  return customerRepo.save(customer);
  }
}
