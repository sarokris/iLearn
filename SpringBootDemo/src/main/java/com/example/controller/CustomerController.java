package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.AppConstants;
import com.example.pojo.Customer;
import com.example.pojo.CustomerRole;
import com.example.service.CustomerRoleService;
import com.example.service.CustomerService;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/customer")
@Api(value="CustomerController", description="Operations pertaining to products in Online Store")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerRoleService customerRoleService;
	
	@RequestMapping("/")
	@ApiIgnore
	public ModelAndView home() {
		List<Customer> listCustomer = customerService.listAll();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listCustomer", listCustomer);
		return mav;
	}
	
	@RequestMapping("/new")
	@ApiIgnore
	public String newCustomerForm(Map<String, Object> model) {
		Customer customer = new Customer( null, null, null, null);
		model.put("customer", customer);
		return "new_customer";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ApiIgnore
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		CustomerRole  role = customerRoleService.getRoleByName(AppConstants.ROLE_USER);
		customer.setRoles(role);
		customerService.save(customer);
		return "redirect:/customer/";
	}
	
	@RequestMapping("/edit")
	@ApiIgnore
	public ModelAndView editCustomerForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("edit_customer");
		Customer customer = customerService.get(id);
		mav.addObject("customer", customer);
		
		return mav;
	}
	
	@RequestMapping("/delete")
	@ApiIgnore
	public String deleteCustomerForm(@RequestParam long id) {
		customerService.delete(id);
		return "redirect:/customer/";		
	}
	
	@RequestMapping("/search")
	@ApiIgnore
	public ModelAndView search(@RequestParam String keyword) {
		List<Customer> result = customerService.search(keyword);
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("result", result);
		
		return mav;		
	}	
}
