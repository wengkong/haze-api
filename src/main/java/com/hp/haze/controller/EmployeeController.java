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
import com.hp.haze.model.Task;
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
		Employee e = employeeRepository.findOne(Integer.valueOf(id));
		e.setManager(employeeRepository.isManager(e));
		return e;
	}

	@RequestMapping(value = "/{id}/compTimes", method = GET)
	public List<CompTime> getCompTimes(@PathVariable("id") String id) {
		log.info("Get comp times " + Integer.valueOf(id));
		// return
		// employeeRepository.findOne(Integer.valueOf(id)).getCompTimes();
		return employeeRepository.getCompTimes(Integer.valueOf(id));
	}

	@RequestMapping(value = "/{id}/tasks", method = GET)
	public List<Task> getTasks(@PathVariable("id") String id) {
		log.info("Get tasks " + Integer.valueOf(id));
		return employeeRepository.getTasks(Integer.valueOf(id));
	}

	/**
	 * Create new task for specific employee
	 * 
	 * @RequestMapping(value = "/{id}/tasks", method = POST) public Task
	 *                       createTask(@RequestBody Task task) { return task;
	 * 
	 *                       }
	 * 
	 * Create new comp time for specific employee
	 * 
	 * @RequestMapping(value = "/{id}/compTimes", method = POST) public CompTime
	 *                       createCompTime(@RequestBody CompTime compTime) {
	 *                       return compTime;
	 * 
	 *                       }
	 * 
	 * @RequestMapping(method = GET, params = { "email" }) public Employee
	 *                        findByEmail(@RequestParam("email") String email) {
	 *                        log.info("Find by email " + email); return
	 *                        employeeRepository.findByEmail(email); }
	 * 
	 * @RequestMapping(method = GET, params = { "fullName" }) public Employee
	 *                        findByFullName(@RequestParam("fullName") String
	 *                        fullName) { log.info("Find by full name " +
	 *                        fullName); return
	 *                        employeeRepository.findByFullName(fullName); }
	 * 
	 * 
	 * @RequestMapping(method = POST) public void login(@RequestBody Employee
	 *                        employee) {
	 * 
	 *                        }
	 **/

	@RequestMapping(value = "/{id}", method = PUT)
	public Employee updateProfile(@PathVariable("id") String id, @RequestBody Employee employee) {
		log.info("Find one " + Integer.valueOf(id));
		Employee updateProfile = employeeRepository.findOne(Integer.valueOf(id));
		updateProfile.setFullName(employee.getFullName());
		updateProfile.setManagerEmail(employee.getManagerEmail());
		return employeeRepository.save(updateProfile);
	}

	@RequestMapping(value = "/{id}", method = DELETE)
	public void delete(@PathVariable("id") String id) {
		employeeRepository.delete((Integer.valueOf(id)));
		// Employee delete = employeeRepository.findOne(Integer.valueOf(id));
	}

}