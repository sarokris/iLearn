package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.pojo.CustomerRole;
import com.example.repository.CustomerRoleRepository;

@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner {
	
	@Autowired
	private CustomerRoleRepository roleRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CustomerRole roleUser = new CustomerRole();
		roleUser.setRoleName(AppConstants.ROLE_USER);
		CustomerRole roleAdmin = new CustomerRole();
		roleAdmin.setRoleName(AppConstants.ROLE_ADMIN);
		roleRepo.save(roleAdmin);
//		roleRepo.save(roleUser);
	}

}
