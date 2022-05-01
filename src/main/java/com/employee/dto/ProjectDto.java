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
public class ProjectDto {

	private String projCode;

	private String projectName;

	Set<DepartmentDto> departments;

	Set<EmployeeDto> employees;

	public ProjectDto(String projCode, String projectName) {
		this.projCode = projCode;
		this.projectName = projectName;
	}

}
