package com.litsakis.crm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.litsakis.crm.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

	// that's it ... no need to write any code LOL!
	//short by last name
	
	public List<Task> findAllByOrderByIdAsc();
}
