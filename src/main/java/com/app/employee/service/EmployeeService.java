package com.app.employee.service;

import com.app.employee.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto create(EmployeeDto employeeDto);

    EmployeeDto update(Long id, EmployeeDto employeeDto);

    void delete(Long id);

    EmployeeDto getEmployeeById(Long id);

    List<EmployeeDto> getAllEmployees();

}
