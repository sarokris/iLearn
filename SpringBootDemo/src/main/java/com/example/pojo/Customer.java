package com.example.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	public Customer(Long id, String name, String email, String address, Set<CustomerRole> roles) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.roles = roles;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String email;
	private String address;

	@ManyToMany
	@JoinTable(name = "customer_role_mapping_solved", joinColumns = {
			@JoinColumn(name = "customer_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", referencedColumnName = "id") })
	private Set<CustomerRole> roles = new HashSet<>(); 

	public Customer() {
	}
	
//	public Customer(String name, String email, String address) {
//		this.name = name;
//		this.email = email;
//		this.address = address;
//	}


	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<CustomerRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<CustomerRole> roles) {
		this.roles = roles;
	}

	

}
