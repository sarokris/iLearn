package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pojo.CustomerRole;

public interface CustomerRoleRepository extends JpaRepository<CustomerRole,Long> {
	public CustomerRole findByRoleName(String roleName);
}
