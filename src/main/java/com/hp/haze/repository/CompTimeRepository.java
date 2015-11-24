package com.hp.haze.repository;

import org.springframework.data.repository.CrudRepository;

import com.hp.haze.model.CompTime;

public interface CompTimeRepository extends CrudRepository<CompTime, Integer>, CompTimeRepositoryCustom {

}
