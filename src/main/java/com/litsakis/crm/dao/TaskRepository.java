package com.litsakis.crm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.litsakis.crm.entity.Customer;
import com.litsakis.crm.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

	// that's it ... no need to write any code LOL!
	//short by last name
	
	public List<Task> findAllByOrderByIdAsc();
	/*
	@Query("SELECT new com.litsakis.entity.Customer(count(x)) FROM Task x,Customer y WHERE x.customer_id=y.id")
    public Customer Taskcustomer();*/
	
	

}
