package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pojo.CustomerRole;
import com.example.repository.CustomerRoleRepository;

@Service
public class CustomerRoleService {
	@Autowired 
	private CustomerRoleRepository roleRepo;
	
	public CustomerRole getRoleByName(String roleName) {
		return roleRepo.findByRoleName(roleName);
	}
	
	public List<CustomerRole> listAll() {
		return roleRepo.findAll();
	}
	
}
