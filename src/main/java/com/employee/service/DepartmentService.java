package com.employee.service;

import java.util.Set;

import com.employee.entity.Department;

public interface DepartmentService {

	Department getByDepartId(String departCode);

	Set<Department> getAllByDepartId(String departCode);

}
