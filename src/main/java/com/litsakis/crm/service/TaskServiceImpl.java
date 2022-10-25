package com.litsakis.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litsakis.crm.dao.TaskRepository;
import com.litsakis.crm.entity.Task;

@Service
public class TaskServiceImpl implements TaskService {
	
	private TaskRepository taskRepository;
	
	@Autowired
	public TaskServiceImpl(TaskRepository theTaskRepository) {
		taskRepository = theTaskRepository;
	}
	
	@Override
	public List<Task> findAll() {
		return taskRepository.findAllByOrderByIdAsc();
	}

	@Override
	public Task findById(int theId) {
		Optional<Task> result = taskRepository.findById(theId);
		
		Task theTask = null;
		
		if (result.isPresent()) {
			theTask = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find Task id - " + theId);
		}
		
		return theTask;
	}

	@Override
	public void save(Task theTask) {
		taskRepository.save(theTask);
	}

	@Override
	public void deleteById(int theId) {
		taskRepository.deleteById(theId);
	}
	
	
	
}
