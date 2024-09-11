package com.app.employee.service.impl;

import com.app.employee.dto.EmployeeDto;
import com.app.employee.entity.Employee;
import com.app.employee.exception.EmployeeException;
import com.app.employee.exception.ResourceNotFoundException;
import com.app.employee.mapper.EmployeeMapper;
import com.app.employee.repository.EmployeeRepo;
import com.app.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private static final String ERROR_MSG = "Employee not found with the ID :";
    private final EmployeeRepo employeeRepo;

    @Override
    public EmployeeDto create(EmployeeDto employeeDto) {
        if (employeeRepo.existsByEmail(employeeDto.getEmail())) {
            throw new EmployeeException("Employee already registered with given mail id");
        } else {
            return EmployeeMapper.mapToEmployeeDto(employeeRepo
                    .save(EmployeeMapper.mapToEmployee(employeeDto)));
        }
    }

    @Override
    public EmployeeDto update(Long id, EmployeeDto employeeDto) {
        Employee updateEmployee = employeeRepo
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ERROR_MSG + id));
        updateEmployee.setFirstName(employeeDto.getFirstName());
        updateEmployee.setLastName(employeeDto.getLastName());
        updateEmployee.setEmail(employeeDto.getEmail());
        return EmployeeMapper.mapToEmployeeDto(employeeRepo
                .save(updateEmployee));
    }

    @Override
    public void delete(Long id) {
        try {
            log.info("EmployeeService - delete ");
            if (employeeRepo.existsById(id)) {
                employeeRepo.deleteById(id);
            } else {
                log.info(ERROR_MSG + " {}", id);
                throw new ResourceNotFoundException(ERROR_MSG + id);
            }
        } catch (Exception exception) {
            log.error("Employee deletion failed !, {}", exception.getMessage());
            throw new ResourceNotFoundException("Employee deletion failed !, " + exception.getMessage());
        }
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        return EmployeeMapper.mapToEmployeeDto(employeeRepo
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ERROR_MSG + id)));
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepo
                .findAll()
                .stream()
                .map(employee -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }
}
