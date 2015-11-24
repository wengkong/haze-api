package com.hp.haze.repository;

import java.util.List;

import com.hp.haze.model.CompTime;
import com.hp.haze.model.Employee;
import com.hp.haze.model.Task;

public interface EmployeeRepositoryCustom {
	public boolean isManager(Employee employee);
	public List<CompTime> getCompTimes(Integer employeeId);
	public List<Task> getTasks(Integer employeeId);
}
