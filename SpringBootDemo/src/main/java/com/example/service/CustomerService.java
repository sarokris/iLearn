package com.example.service;

import java.util.List;
import java.util.Optional;

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

	@Autowired
	private CustomerRepository repo;
	
	@Autowired
	private CustomerRoleRepository roleRepo;

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

	public String getRole(Long roleId) {
		Optional<CustomerRole> role =  roleRepo.findById(roleId);
		return role.map(CustomerRole::getRoleName).orElse("NoRoleFound");
	}

	public String addRole(CustomerRoleDTO roleDto) {
		String output = "Succcessfully Role added to the user";
		Optional<CustomerRole> cusRole = Optional.ofNullable(roleRepo.findByRoleName(roleDto.getRoleName()));
		if (cusRole.isPresent()) {
			output = "Role alread present in DB";
		} else {
			CustomerRole role = new CustomerRole();
			role.setRoleName(roleDto.getRoleName());
			roleRepo.save(role);
		}

		return output;
	}

}
