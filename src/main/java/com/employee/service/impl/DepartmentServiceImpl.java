package com.employee.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Department;
import com.employee.repository.DepartmentRepository;
import com.employee.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department getByDepartId(String departCode) {
		return departmentRepository.findById(departCode).get();
	}

	@Override
	public Set<Department> getAllByDepartId(String departCode) {
		return departmentRepository.findByDepartCode(departCode);
	}

}
