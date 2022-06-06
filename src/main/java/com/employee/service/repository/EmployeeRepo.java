package com.employee.service.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

	Optional<Employee> findByName(String name);

}
