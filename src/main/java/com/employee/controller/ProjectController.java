package com.employee.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.ProjectDto;
import com.employee.entity.Project;
import com.employee.service.ProjectService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/{projCode}")
	public Project getProjectByCode(@PathVariable String projCode){
		return projectService.getProjectByCode(projCode);
		
	}
	
	@GetMapping
	public Set<Project> getProjectsByGivenListOfCode(@RequestParam List<String> projCodes){
		return projectService.getProjectsByCodes(projCodes);
		
	}

	@GetMapping("/{projCode}/department/{departCode}")
	public Set<ProjectDto> getProjectByCodeAndDepartCode(@PathVariable String projCode,@PathVariable String departCode){
		return projectService.getProjectByCodeAndDepartCode(projCode, departCode);
		
	}

}
