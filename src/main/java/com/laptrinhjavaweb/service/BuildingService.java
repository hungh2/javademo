package com.laptrinhjavaweb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.convert.BuildingConverter;
import com.laptrinhjavaweb.model.BuildingModel;
import com.laptrinhjavaweb.model.response.BuildingSearchResponse;
import com.laptrinhjavaweb.repository.BuildingRepository;


public interface BuildingService {
	
	List<BuildingSearchResponse> getAll(Map<String, Object> params, List<String> types);
	void save(BuildingModel buildingModel);
	
	
	
}
