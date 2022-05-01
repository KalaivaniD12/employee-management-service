package com.employee.service;

import java.util.List;
import java.util.Optional;

import com.employee.entity.Employee;


public interface EmployeeService {

	Optional<Employee> getEmpById(String empCode);

	List<Employee> getAllEmployee();

	Employee addEmployee();

}
