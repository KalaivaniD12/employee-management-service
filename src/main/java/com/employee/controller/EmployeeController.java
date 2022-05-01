package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping()
	public List<Employee> getAllEmployee() {
		return this.employeeService.getAllEmployee();

	}
	
	@GetMapping(value = "/{empCode}")
	public Employee getEmployeeById(@PathVariable String empCode) {
		return this.employeeService.getEmpById(empCode).get();

	}
	@PostMapping(value="/add")
	public Employee addeEmployee(@RequestBody Employee employee){
		return this.employeeService.addEmployee();
	}
}
