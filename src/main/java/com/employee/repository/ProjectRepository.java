package com.employee.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.Department;
import com.employee.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String>{

	
	Set<Project> findByProjCodeAndDepartmentsIn(String projCode, Set<Department> departments);

	Set<Project> findByProjCodeIn(List<String> projCodes);

	Set<Project> findByProjCodeAndDepartments(String projCode, Department department);

	Set<Project> findByProjCodeIn(Set<String> listOfProjCode);

}
