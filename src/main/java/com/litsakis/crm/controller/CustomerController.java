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
import com.litsakis.crm.service.CustomerService;
 

@Controller
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService customerService;
	
	public CustomerController(CustomerService theCustomerService) {
		customerService = theCustomerService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		// get employees from db
		List<Customer> theCustomers = customerService.findAll();
		
		// add to the spring model
		theModel.addAttribute("customers", theCustomers);
		
		return "customers/list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd( Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute(theCustomer);
		
		
		return "customers/customer-form";
		
	}

	
	@PostMapping("save")
	public String saveCustomer (@ModelAttribute("employee") Customer theCustomer) {
		customerService.save(theCustomer);
		
			
		return "redirect:/customers/list";

	}
	@GetMapping("showFormForUpdate")
	public String showFormForUpdate (@RequestParam("customerId") int theId,
			Model theModel) {
		Customer theCustomer  =  customerService.findById(theId);
		
		theModel.addAttribute("customer",theCustomer);
		
		 
		
			
		return "/customers/customer-form";

	}
	
	
	@GetMapping("delete")
	public String delete (@RequestParam("customerId") int theId,
			Model theModel) {
		
		customerService.deleteById(theId);
		 
		 
		
			
		return "redirect:/customers/list";

	}
}









