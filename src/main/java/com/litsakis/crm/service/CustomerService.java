package com.litsakis.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.litsakis.crm.entity.Customer;
@Service
public interface CustomerService {

	public List<Customer> findAll();
	public Customer findById(int theId);
	public void save (Customer theCustomer);
	public void deleteById (int theId);
	
}
