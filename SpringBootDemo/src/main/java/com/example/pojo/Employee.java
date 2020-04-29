package com.example.pojo;

public class Employee {
	
	public Employee( String name, String empId,String dept) {
		super();
		this.dept = dept;
		this.name = name;
		this.empId = empId;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String dept;

	private String name;
	
	private String empId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	

}
