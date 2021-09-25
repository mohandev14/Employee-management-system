package com.EmployeeInfromation.api.service;

import java.util.List;

import com.EmployeeInfromation.api.model.Employee;

public interface EmployeeService {

	List<Employee> getallempEmployees();
	void saveEmployee(Employee employee);
	
	Employee getEmployeeById(long id);
}
