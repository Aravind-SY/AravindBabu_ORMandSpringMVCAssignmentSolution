package com.gl.customerrelationship.service;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;

import com.gl.customerrelationship.entity.Customer;
import com.gl.customerrelationship.service.CustomerRelationshipManagementSer;
	
	@Controller
	@RequestMapping("/customer")
	public class CustomerRelationshipMangementController {

		@Autowired
		private CustomerRelationshipManagementSer custRelService;

		// add mapping for "/list"
		@RequestMapping("/list")
		public String listCustomers(Model theModel) {

			System.out.println("inside listCustomers");
			// Get Customer List from DB
			List<Customer> custListManagement = custRelService.findAll();

			// Add to the spring model
			theModel.addAttribute("CustomersList", custListManagement);

			return "list-Customers";
		}

		@RequestMapping("/showFormForAdd")
		public String showFormForAdd(Model theModel) {

			// create model attribute to bind form data
			Customer custRelEntity = new Customer();

			theModel.addAttribute("Customers", custRelEntity);

			return "Customers-form";
		}

		@RequestMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("custId") int theId, Model theModel) {

			// get the customer from the service
			Customer custRelEntity = custRelService.findById(theId);

			// set Customers as a model attribute to pre-populate the form
			theModel.addAttribute("Customers", custRelEntity);

			// send over to our form
			return "Customers-form";
		}

		@PostMapping("/save")
		public String saveCustomers(@RequestParam("id") int id, @RequestParam("firstname") String firstname,
				@RequestParam("lastname") String lastname, @RequestParam("email") String email) {

			System.out.println(id);
			Customer custEntity;
			if (id != 0) {
				custEntity = custRelService.findById(id);
				custEntity.setFirstname(firstname);
				custEntity.setLastname(lastname);
				custEntity.setEmail(email);
			} else
				custEntity = new Customer(firstname, lastname, email);
			// save the customer
			custRelService.save(custEntity);

			// use a redirect to prevent duplicate submissions
			return "redirect:/customer/list";

		}

		@RequestMapping("/delete")
		public String delete(@RequestParam("custId") int theId) {

			// delete the customer
			custRelService.deleteById(theId);

			return "redirect:/customer/list";

		}

	}
