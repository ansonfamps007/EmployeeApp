package com.employee.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.bean.EmployeeBean;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import com.employee.service.exception.EmployeeException;
import com.employee.service.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public String createEmployee(EmployeeBean employee) throws EmployeeException {
		
		try {
			Employee emp = Employee.builder().name(employee.getName()).age(employee.getAge()).dept(employee.getDept())
					.salary(employee.getSalary()).build();
			employeeRepo.save(emp);
		} catch (Exception e) {
			throw new EmployeeException("Creation Failed !");
		}
		
		return "Employee Created ";
	}

	@Override
	public Employee getEmployee(String name) throws EmployeeException {
		
		Optional<Employee> emp = employeeRepo.findByName(name);
		if(emp.isPresent()) {
			Employee tempEmp = emp.get();
			EmployeeBean employee = new EmployeeBean();
			employee.setAge(tempEmp.getAge());
			employee.setDept(tempEmp.getDept());
			employee.setSalary(tempEmp.getSalary());
			employee.setName(tempEmp.getName());
			return tempEmp;
		} else {
			throw new EmployeeException("No Employee Found !");
		}
		
		
	}

}
