package com.hp.haze.repository;

import org.springframework.data.repository.CrudRepository;

import com.hp.haze.model.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> { 	
	
}
