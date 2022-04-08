package com.laptrinhjavaweb.convert;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.model.response.BuildingSearchResponse;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.entity.DistrictEntity;

@Component
public class BuildingConverter {

	 private ModelMapper modelMapper = new ModelMapper();
	 
    public BuildingSearchResponse convertToBuildingSearchResponse(BuildingEntity entity) {
    	BuildingSearchResponse buildingSearchResponse = modelMapper.map(entity, BuildingSearchResponse.class);
    	
    	
        return buildingSearchResponse;
	}
    
	
   
}