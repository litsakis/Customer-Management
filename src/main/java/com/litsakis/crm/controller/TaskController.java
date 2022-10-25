package com.litsakis.crm.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.litsakis.crm.entity.Customer;
import com.litsakis.crm.entity.Task;
import com.litsakis.crm.service.CustomerService;
import com.litsakis.crm.service.TaskService;
 

@Controller
@RequestMapping("/tasks")
public class TaskController {

	private TaskService taskService;
	private	CustomerService customerService;

	public TaskController(TaskService theTaskService,CustomerService theCustomerService) {
		taskService = theTaskService;
		customerService=theCustomerService;

	}
	 
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listTasks(Model theModel) {
		
		// get employees from db
		List<Task> theTasks = taskService.findAll();
		
		// add to the spring model
		theModel.addAttribute("tasks", theTasks);
		
		return "tasks/list-tasks";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(@RequestParam("customerId") int theId, Model theModel) {
		Task theTask = new Task();
		
		theTask.setCustomer(customerService.findById(theId));
		theModel.addAttribute(theTask);
		
		
		return "tasks/task-form";
		
	}

	
	@PostMapping("save")
	public String saveTask (@ModelAttribute("task") Task theTask) {
		taskService.save(theTask);
		
			
		return "redirect:/tasks/list";

	}
	@GetMapping("showFormForUpdate")
	public String showFormForUpdate (@RequestParam("taskId") int theId,
			Model theModel) {
		Task theTask  =  taskService.findById(theId);
		
		theModel.addAttribute("task",theTask);
		
		 
		
			
		return "/tasks/task-form";

	}
	
	
	@GetMapping("delete")
	public String delete (@RequestParam("taskId") int theId,
			Model theModel) {
		
		taskService.deleteById(theId);
		 
		 
		
			
		return "redirect:/tasks/list";

	}
}









