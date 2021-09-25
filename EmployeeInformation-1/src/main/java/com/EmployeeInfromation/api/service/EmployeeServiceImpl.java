package com.EmployeeInfromation.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeInfromation.api.model.Employee;
import com.EmployeeInfromation.api.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeerepository;
	@Override
	public List<Employee> getallempEmployees() {
		return employeerepository.findAll();
		
	}
	@Override
	public void saveEmployee(Employee employee) {
		this.employeerepository.save(employee);
		
	}
	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional = employeerepository.findById(id);
		Employee employee =null;
		if(optional.isPresent()) {
			employee = optional.get();
		}else
		{
			throw new RuntimeException("Employee not found in id ::"+id);
		}
		return employee;
	}
	}


 