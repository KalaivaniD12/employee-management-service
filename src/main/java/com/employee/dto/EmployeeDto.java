package com.employee.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(value = Include.NON_NULL)
public class EmployeeDto {

	private String empCode;

	private String name;

	private Integer salary;

	private Set<String> deptCode;

	Set<DepartmentDto> departments;

	Set<ProjectDto> projects;

	public EmployeeDto(String empCode, String name, Integer integer, Set<String> deptCode) {
		this.empCode = empCode;
		this.name = name;
		this.salary = integer;
		this.deptCode = deptCode;
	}

}
