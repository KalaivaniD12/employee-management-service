package com.employee.service;

import java.util.List;
import java.util.Set;

import com.employee.dto.ProjectDto;
import com.employee.entity.Project;

public interface ProjectService {

	Set<ProjectDto> getProjectByCodeAndDepartCode(String projCode, String departCode);

	Project getProjectByCode(String projCode);

	Set<Project> getProjectsByCodes(List<String> projCodes);

}
