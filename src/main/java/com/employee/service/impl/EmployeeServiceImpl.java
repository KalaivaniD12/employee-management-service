package com.employee.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Department;
import com.employee.entity.Employee;
import com.employee.entity.Project;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Optional<Employee> getEmpById(String empCode) {
		return employeeRepository.findById(empCode);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee addEmployee() {
		return this.employeeRepository.save(setEmployee());
	}
	
	private Employee setEmployee() {
		
		Project proj=new Project("P1001","Project1");
		Set<Project> setOfProject=new HashSet<>();
		setOfProject.add(proj);
		Department dept=new Department("D101","Dept1");
		Set<Department> setOfDept=new HashSet<>();
		setOfDept.add(dept);
		Employee employee=new Employee("E10001","Kalai",50000, setOfDept, setOfProject);
		
		return employee;
	}

}
