package com.example.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerRoleDTO {
	public CustomerRoleDTO() {
		super();
	}

	public CustomerRoleDTO(Long roleId, Long customerId,String roleName) {
		super();
		this.roleId = roleId;
		this.customerId = customerId;
		this.roleName = roleName;
	}

	private Long roleId;
	
	private String roleName;

	private Long customerId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
