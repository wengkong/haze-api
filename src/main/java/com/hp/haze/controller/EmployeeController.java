package com.hp.haze.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

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
import com.hp.haze.repository.EmployeeRepository;

@EnableAutoConfiguration
@RequestMapping("/employees")
@RestController
public class EmployeeController {
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeRepository employeeRepository;

	@RequestMapping(method = GET)
	public Iterable<Employee> findAll() {
		log.info("Find all");
		return employeeRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = GET)
	public Employee findOne(@PathVariable("id") String id) {
		log.info("Find one " + Integer.valueOf(id));
		return employeeRepository.findOne(Integer.valueOf(id));
	}

	@RequestMapping(value = "/{id}/compTimes", method = GET)
	public List<CompTime> getCompTimes(@PathVariable("id") String id) {
		log.info("Get comp times " + Integer.valueOf(id));
		//return employeeRepository.findOne(Integer.valueOf(id)).getCompTimes();
		return employeeRepository.getCompTimes(Integer.valueOf(id));
	}
	
	@RequestMapping(method = GET, params = { "email" })
	public Employee findByEmail(@RequestParam("email") String email) {
		log.info("Find by email " + email);
		return employeeRepository.findByEmail(email);
	}

	@RequestMapping(method = GET, params = { "fullName" })
	public Employee findByFullName(@RequestParam("fullName") String fullName) {
		log.info("Find by full name " + fullName);
		return employeeRepository.findByFullName(fullName);
	}
	
	@RequestMapping(method = POST)
	public void login(@RequestBody Employee employee) {
		
	}
}
