package com.employee.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String>{

	Set<Department> findByDepartCode(String departCode);
	
	Optional<Department> findById(String departCode);

}
