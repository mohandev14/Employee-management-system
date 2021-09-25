package com.EmployeeInfromation.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.EmployeeInfromation.api.model.Employee;
import com.EmployeeInfromation.api.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String viewhomepage(Model model) {
		
		model.addAttribute("listEmployees",employeeService.getallempEmployees() );
		return "index";
	}
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model ) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/"; 
		
	}
}
