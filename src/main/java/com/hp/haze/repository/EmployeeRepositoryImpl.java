package com.hp.haze.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.hp.haze.model.CompTime;
import com.hp.haze.model.Employee;
import com.hp.haze.model.Task;

public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {

	@Autowired
	private EntityManager entityManager;

	@Override
	public boolean isManager(Employee employee) {
		//System.out.println(employee.getManagerEmail()); 
		//TypedQuery<Employee> query = entityManager.createQuery("select e from Employee as e where e.managerEmail = :email", Employee.class);
		Query query = entityManager.createQuery("select count(e.managerEmail) from Employee as e where e.managerEmail = :email");
		query.setParameter("email", employee.getEmail());		
		return ((Long) query.getSingleResult()).intValue()>0;
		
		//return query.getResultList().size()>0;
		 
		//Employee i = (Employee) o;
		//int x = i.intValue();
		//if (i == null) {
			//return false;
		//} else {
		//	return true;
		//}
	}

	@Override
	public List<CompTime> getCompTimes(Integer employeeId) {
		TypedQuery<CompTime> query = entityManager
				.createQuery("SELECT c FROM CompTime AS c WHERE c.employee.id = :employeeId", CompTime.class);
		query.setParameter("employeeId", employeeId);
		return query.getResultList();
	}

	@Override
	public List<Task> getTasks(Integer employeeId) {
		TypedQuery<Task> query = entityManager.createQuery("SELECT c FROM Task AS c WHERE c.employee.id = :employeeId",
				Task.class);
		query.setParameter("employeeId", employeeId);
		return query.getResultList();
	}

}
