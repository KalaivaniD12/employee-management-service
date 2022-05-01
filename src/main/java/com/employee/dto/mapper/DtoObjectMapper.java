package com.employee.dto.mapper;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.employee.dto.DepartmentDto;
import com.employee.dto.EmployeeDto;
import com.employee.dto.ProjectDto;
import com.employee.entity.Department;
import com.employee.entity.Employee;
import com.employee.entity.Project;

public class DtoObjectMapper {

	public static Set<ProjectDto> mapToProjectSet(Set<Project> projectSet) {
		Set<ProjectDto> projSet = new HashSet<>();

		projectSet.forEach(p -> {
			setProjects(projSet, p);

		});
		return projSet;

	}
	
	public static Set<Department> mapToDepartSet(Set<Department> departmentSet) {
		Set<Department> deptSet = new HashSet<>();

		departmentSet.forEach(d -> {
			setDepartments(deptSet, d);

		});
		return deptSet;

	}

	private static void setDepartments(Set<Department> deptSet, Department d) {
		
	}

	private static void setProjects(Set<ProjectDto> projSet, Project p) {

		Set<EmployeeDto> empSet = new HashSet<>();
		Set<DepartmentDto> deptSet = new HashSet<>();
		addDept(p.getDepartments(), empSet, deptSet, projSet);
		addEmp(p.getEmployees(), empSet, deptSet, projSet);
		ProjectDto pDto = new ProjectDto(p.getProjCode(), p.getProjectName(), deptSet, empSet);
		projSet.add(pDto);
	}

	private static void addDept(Set<Department> departments, Set<EmployeeDto> empSet, Set<DepartmentDto> deptSet,
			Set<ProjectDto> projSet) {
		if (!departments.isEmpty()) {
			departments.forEach(d -> {
				Set<Employee> e=d.getEmployees();
				Set<String> empIds= e.stream().map(Employee::getEmpCode).collect(Collectors.toSet());
				DepartmentDto departmentDto = new DepartmentDto(d.getDepartCode(), d.getDeptName(), empIds);
				deptSet.add(departmentDto);

				/*
				 * addEmp(d.getEmployees(), empSet, deptSet, projSet);
				 * addProject(d.getProjects(), empSet, deptSet, projSet);
				 */

			});
		}

	}

	private static void addEmp(Set<Employee> employees, Set<EmployeeDto> empSet, Set<DepartmentDto> deptSet,
			Set<ProjectDto> projSet) {
		if (!employees.isEmpty()) {
			employees.forEach(e -> {
				Set<Department> d=e.getDepartments();
				Set<String> deptIds= d.stream().map(Department::getDepartCode).collect(Collectors.toSet());
				EmployeeDto empDto = new EmployeeDto(e.getEmpCode(), e.getName(), e.getSalary(), deptIds);
				empSet.add(empDto);

				/*
				 * addDept(e.getDepartments(), empSet, deptSet, projSet);
				 * addProject(e.getProjects(), empSet, deptSet, projSet);
				 */

			});
		}

	}

	public static void addProject(Set<Project> projects, Set<EmployeeDto> empSet, Set<DepartmentDto> deptSet,
			Set<ProjectDto> projSet) {
		if (!projects.isEmpty()) {
			projects.forEach(p -> {

				ProjectDto pDto = new ProjectDto(p.getProjCode(), p.getProjectName(), deptSet, empSet);
				projSet.add(pDto);
				/*
				 * addEmp(p.getEmployees(), empSet, deptSet, projSet);
				 * addDept(p.getDepartments(), empSet, deptSet, projSet);
				 */
			});
		}

	}

}
