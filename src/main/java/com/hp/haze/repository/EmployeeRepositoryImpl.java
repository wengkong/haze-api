package com.hp.haze.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.hp.haze.model.CompTime;
import com.hp.haze.model.Employee;

public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {

	@Autowired
    private EntityManager entityManager;
	
	@Override
	public boolean isManager(Employee employee) {
		boolean isManager = false;
		// TODO Auto-generated method stub
		// check is there any employee having the pass in employee manager's email
		employee.setManager(isManager);
		return isManager;
	}

	@Override
	public List<CompTime> getCompTimes(Integer employeeId) {
		TypedQuery<CompTime> query = entityManager.createQuery("SELECT c FROM CompTime AS c WHERE c.employee.id = :employeeId", CompTime.class);
		query.setParameter("employeeId", employeeId);
		return query.getResultList();
	}

	
}
