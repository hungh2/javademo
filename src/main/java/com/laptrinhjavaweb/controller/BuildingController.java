package com.laptrinhjavaweb.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.laptrinhjavaweb.model.BuildingModel;
import com.laptrinhjavaweb.model.response.BuildingSearchResponse;
import com.laptrinhjavaweb.service.BuildingService;
import com.laptrinhjavaweb.service.impl.BuildingServiceImpl;


public class BuildingController {
	
	
	private static BuildingService buildingService = new BuildingServiceImpl();
	
	public List<BuildingModel> showbuilding(Integer floorArea, String name,Integer numberOfBasement, String street){
		//List<BuildingModel> results = buildingService.showBuilding(floorArea, name, numberOfBasement, street);	
		return null;		
	}
	
	public void save(BuildingModel buildingModel) {
		buildingService.save(buildingModel);
	}


	public List<BuildingSearchResponse> findAll(Map<String, Object> params, List<String> types) {
		List<BuildingSearchResponse> results = buildingService.getAll( params, types);
		return results;
	}
}
