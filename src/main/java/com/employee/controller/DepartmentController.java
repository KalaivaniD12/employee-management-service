package com.employee.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Department;
import com.employee.service.DepartmentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping(value = "/{departCode}")
	public Department departCode(@PathVariable String departCode) {
		
		return this.departmentService.getByDepartId(departCode);
		
	}
	
	@GetMapping(value = "/all/{departCode}")
	public Set<Department> getAllDepartmentByDepartCode(@PathVariable String departCode) {
		
		return this.departmentService.getAllByDepartId(departCode);
		
	}

}
