package com.gl.customerrelationship.dao;

	import java.util.List;

	import javax.transaction.Transactional;

	import org.hibernate.HibernateException;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;

import com.gl.customerrelationship.entity.Customer;
import com.gl.customerrelationship.service.CustomerRelationshipManagementSer;

	@Repository
	public class CustomerRelationManagementImp implements CustomerRelationshipManagementSer {

		private SessionFactory sessionFactory;

		// create session
		private Session session;

		@Autowired
		CustomerRelationManagementImp(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
			try {
				session = sessionFactory.getCurrentSession();
			} catch (HibernateException e) {
				session = sessionFactory.openSession();
			}

		}

		@Transactional
		public List<Customer> findAll() {

			Transaction tx = session.beginTransaction();

			// find all the records from the database table
			List<Customer> custList = session.createQuery("from Customers").list();

			tx.commit();

			return custList;
		}

		@Transactional
		public Customer findById(int id) {

			Customer customer = new Customer();

			Transaction tx = session.beginTransaction();

			// find record with Id from the database table
			customer = session.get(Customer.class, id);

			tx.commit();

			return customer;
		}

		@Transactional
		public void save(Customer customer) {

			Transaction tx = session.beginTransaction();

			// save transaction
			session.saveOrUpdate(customer);

			tx.commit();

		}

		@Transactional
		public void deleteById(int id) {

			Transaction tx = session.beginTransaction();

			// get transaction
			Customer customer = session.get(Customer.class, id);

			// delete record
			session.delete(customer);

			tx.commit();

		}

		@Transactional
		public List<Customer> searchBy(String Name, String Author) {

			Transaction tx = session.beginTransaction();
			String query = "";
			if (Name.length() != 0 && Author.length() != 0)
				query = "from customers where name like '%" + Name + "%' or author like '%" + Author + "%'";
			else if (Name.length() != 0)
				query = "from customers where name like '%" + Name + "%'";
			else if (Author.length() != 0)
				query = "from customers where author like '%" + Author + "%'";
			else
				System.out.println("Cannot search without input data");

			List<Customer> customer = session.createQuery(query).list();

			tx.commit();

			return customer;
		}

		// print the loop
		@Transactional
		public void print(List<Customer> cust) {

			for (Customer c : cust) {
				System.out.println(c);
			}
		}

	}
