package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.CustomerRole;
import com.example.pojo.CustomerRoleDTO;
import com.example.service.CustomerRoleService;
import com.example.service.CustomerService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/role")
public class CustomerRoleController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerRoleService customerRoleService;
	
	
	@GetMapping("/{id}")
	@ApiOperation(value="get the role of the given customer",response=String.class)
	public String getRole(@PathVariable(name="id") Long customerId) {
		return customerService.getRole(customerId);
		
	}
	
	@GetMapping("/name/{role}")
	@ApiOperation(value="Return the role Object with given roleName",response=CustomerRole.class)
	public CustomerRole getRoleByName(@PathVariable(name="role") String roleName) {
		return customerRoleService.getRoleByName(roleName);
		
	}
	
	@GetMapping
	public List<CustomerRole> listAll(){
		return customerRoleService.listAll();
	}
	
	@PostMapping
	public String addRole(@RequestBody @Valid CustomerRoleDTO role) {
		return customerService.addRole(role); 
		
	}
	
	
	
	

}
