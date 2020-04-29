package com.example.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer_role")
public class CustomerRole {

	public CustomerRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerRole(Integer id, String roleName, Set<Customer> customer) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.customer = customer;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "role_name")
	private String roleName;
	
	@ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL)
	private Set<Customer> customer = new HashSet<>(); 
	
//	@OneToMany
//	@JoinColumn(name = "fk_role_id")
//    private List<Customer> customers = new ArrayList<Customer>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(Set<Customer> customer) {
		this.customer = customer;
	}

	
	
//	public void addCustomers(Customer customer) {
//        customers.add(customer);
//        customer.setRole(this);
//    }
// 
//    public void removeCustomers(Customer customer) {
//        customers.remove(customer);
//        customer.setRole(null);
//    }
//
//	public List<Customer> getCustomers() {
//		return customers;
//	}
//
//	public void setCustomers(List<Customer> customers) {
//		this.customers = customers;
//	}


}
