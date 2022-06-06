package com.employee.service;

import com.employee.bean.EmployeeBean;
import com.employee.entity.Employee;
import com.employee.service.exception.EmployeeException;

public interface EmployeeService {
	
	String createEmployee(EmployeeBean employee) throws EmployeeException;

	Employee getEmployee(String name) throws EmployeeException;

}
