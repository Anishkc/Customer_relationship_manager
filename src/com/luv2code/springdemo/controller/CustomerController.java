package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//inject the customer service
	@Autowired 
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		//get customers from the DAO
		List<Customer> theCustomer = customerService.getCustomers();
		
		//add the customer  to the model
		theModel.addAttribute("customers", theCustomer);
		
		return "list-customer";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model themodel) {
		
		Customer thecustomer = new Customer();
		
		themodel.addAttribute("customer", thecustomer);
		
		 return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		//save the customer
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId")int theid,
											Model theModel) {
		//get the customer  from the service
		Customer theCustomer = customerService.getCustomer(theid);
		
		//set customer  as a model attribute  to pre-populate the form
		theModel.addAttribute("customer",theCustomer);
		
		//send over  to our form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId")int theId) {
		
		//delete the customer
		customerService.deleteCustomer(theId);
		
		
		return "redirect:/customer/list";
	}
	
	
	
		
	
	
	
	
}
