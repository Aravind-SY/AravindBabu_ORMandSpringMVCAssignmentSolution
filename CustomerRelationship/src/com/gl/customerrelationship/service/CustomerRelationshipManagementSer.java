package com.gl.customerrelationship.service;

	import java.util.List;

	import org.springframework.stereotype.Service;

import com.gl.customerrelationship.entity.Customer;

	@Service
	public interface CustomerRelationshipManagementSer {
		public List<Customer> findAll();

		public Customer findById(int theId);

		public void save(Customer theBook);

		public void deleteById(int theId);

		public List<Customer> searchBy(String name, String author);

	}

