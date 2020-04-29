package com.example.rs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private Environment env;
	
	@GetMapping(value="/{id}")
	public Employee getEmployee(@PathVariable("id") String id) {
		return new Employee("Anand","101",env.getProperty("department"));
		
	}
	
	

}
