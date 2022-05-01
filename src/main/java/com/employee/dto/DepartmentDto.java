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
public class DepartmentDto {

	private String departCode;

	private String departName;
	
	private Set<String> empIds;

	Set<EmployeeDto> employees;

	Set<ProjectDto> projects;

	public DepartmentDto(String departCode, String departName, Set<String> empIds) {
		this.departCode = departCode;
		this.departName = departName;
		this.empIds = empIds;
	}

	
}
