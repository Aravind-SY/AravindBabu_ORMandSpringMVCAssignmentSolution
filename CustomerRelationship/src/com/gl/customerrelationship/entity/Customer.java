package com.gl.customerrelationship.entity;


	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name = "customer")
	public class Customer {

		// define fields

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private int id;

		@Column(name = "firstname")
		private String firstname;

		@Column(name = "lastname")
		private String lastname;

		@Column(name = "email")
		private String email;

		// define constructors

		public Customer() {

		}

		public Customer(String firstname, String lastname, String email) {
			super();

			this.firstname = firstname;
			this.lastname = lastname;
			this.email = email;
		}

		// define getter/setter

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public String toString() {
			return "CustRelMangementEntity [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
					+ email + "]";
		}

	}