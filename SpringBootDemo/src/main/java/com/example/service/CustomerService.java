package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pojo.Customer;
import com.example.pojo.CustomerRole;
import com.example.pojo.CustomerRoleDTO;
import com.example.repository.CustomerRepository;
import com.example.repository.CustomerRoleRepository;

@Service
@Transactional
public class CustomerService {
	@Autowired CustomerRepository repo;
	
	
	
	public void save(Customer customer) {
		repo.save(customer);
	}
	
	public List<Customer> listAll() {
		return (List<Customer>) repo.findAll();
	}
	
	public Customer get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<Customer> search(String keyword) {
		return repo.search(keyword);
	}
	
	public String getRole(Long customerId) {
//		List<CustomerRoleMapping> role = roleRepo.findByCustomerId(customerId);
//		if(role.stream().anyMatch(x -> 1 == x.getRoleId())) {
//			return "ADMIN";
//		}
		return "USER";
	}

	public String addRole(CustomerRoleDTO roleDto) {
//		Customer c = repo.findById(roleDto.getCustomerId()).get();
//		CustomerRoleMapping role = new CustomerRoleMapping(roleDto.getRoleId(),c.getId(),c);
//		roleRepo.save(role);
		return "Succcessfully Role added to the user";
	}

	
}
