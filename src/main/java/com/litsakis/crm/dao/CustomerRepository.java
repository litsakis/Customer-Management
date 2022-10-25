package com.litsakis.crm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.litsakis.crm.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	// that's it ... no need to write any code LOL!
	//short by last name
	
	public List<Customer> findAllByOrderByLastNameAsc();
}
