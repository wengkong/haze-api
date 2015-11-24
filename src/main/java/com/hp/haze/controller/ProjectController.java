package com.hp.haze.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hp.haze.model.CompTime;
import com.hp.haze.model.Employee;
import com.hp.haze.model.Project;
import com.hp.haze.repository.EmployeeRepository;
import com.hp.haze.repository.ProjectRepository;

@EnableAutoConfiguration
@RequestMapping("/projects")
@RestController
public class ProjectController {
	private static final Logger log = LoggerFactory.getLogger(ProjectController.class);

	@Autowired
	ProjectRepository projectRepository;

	@RequestMapping(method = GET)
	public Iterable<Project> findAll() {
		log.info("Find all");
		return projectRepository.findAll();
	}
	/**
	@RequestMapping(method = POST)//x
	public Project createProject (@RequestBody Project project) {
		return project;	
	}
	
	@RequestMapping(value = "/{id}", method = PUT)//x
	public Project updateProject(@PathVariable("id") String id, @RequestBody Project project) {
		log.info("Find one " + Integer.valueOf(id));
		Project updateProject = projectRepository.findOne(Integer.valueOf(id));
		updateProject.setProjectName(project.getProjectName());
		updateProject.setProjectDescription(project.getProjectDescription());
		return projectRepository.save(updateProject);
	}
	**/
}