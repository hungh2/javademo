package com.laptrinhjavaweb.repository;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.model.response.BuildingSearchResponse;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;


public interface BuildingRepository extends JdbcRepository<BuildingEntity> {
	//List<BuildingEntity> findAll(BuildingSearchResponse buildingSearchResponse);
	List<BuildingEntity> searchBuilding(Map<String, Object> params, List<String> types);
	
}




