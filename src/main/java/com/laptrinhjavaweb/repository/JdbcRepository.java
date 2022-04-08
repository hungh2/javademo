package com.laptrinhjavaweb.repository;

import java.util.List;

import com.laptrinhjavaweb.model.response.BuildingSearchResponse;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;

public interface JdbcRepository<T> {
	List<T> findAll();
	T findById(Long id);
	Long insert(Object object);
	T update(Object updateObject);
	void delete(Long id);
	List<T> findByCondition(String sql);
	//List<T> searchBuilding(String sql);
	//List<BuildingEntity> searchBuilding(BuildingSearchResponse buildingSearchResponse);
}
