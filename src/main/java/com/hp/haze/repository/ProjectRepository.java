package com.hp.haze.repository;

import org.springframework.data.repository.CrudRepository;

import com.hp.haze.model.Project;

public interface ProjectRepository extends CrudRepository < Project, Integer>, ProjectRepositoryCustom{


}
