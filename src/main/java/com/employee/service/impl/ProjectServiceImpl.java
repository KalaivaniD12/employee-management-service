package com.employee.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dto.ProjectDto;
import com.employee.dto.mapper.DtoObjectMapper;
import com.employee.entity.Department;
import com.employee.entity.Project;
import com.employee.repository.DepartmentRepository;
import com.employee.repository.ProjectRepository;
import com.employee.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Set<ProjectDto> getProjectByCodeAndDepartCode(String projCode, String departCode) {

		Department departments = departmentRepository.findById(departCode).get();

		Set<Project> projectSet = projectRepository.findByProjCodeAndDepartments(projCode, departments);
		return DtoObjectMapper.mapToProjectSet(projectSet);
	}

	@Override
	public Project getProjectByCode(String projCode) {
		return projectRepository.findById(projCode).get();
	}

	@Override
	public Set<Project> getProjectsByCodes(List<String> projCodes) {
		return projectRepository.findByProjCodeIn(projCodes);
	}

}
