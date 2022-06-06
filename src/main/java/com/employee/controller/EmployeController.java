package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.bean.EmployeeBean;
import com.employee.entity.Employee;
import com.employee.service.exception.EmployeeException;
import com.employee.service.impl.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeController {

	@Autowired
	private EmployeeServiceImpl employeeService;

	@PostMapping("/create")
	public String createEmployee(@RequestBody EmployeeBean employee) throws EmployeeException {
		return employeeService.createEmployee(employee);
	}
	
	@GetMapping("/get/{name}")
	public Employee getEmployee(@PathVariable String name) throws EmployeeException {
		return employeeService.getEmployee(name);
	}

}
