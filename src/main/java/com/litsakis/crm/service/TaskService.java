package com.litsakis.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.litsakis.crm.entity.Customer;
import com.litsakis.crm.entity.Task;
@Service
public interface TaskService {

	public List<Task> findAll();
	public Task findById(int theId);
	public void save (Task theTask);
	public void deleteById (int theId);
	
}
