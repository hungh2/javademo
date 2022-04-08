package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.convert.BuildingConverter;
import com.laptrinhjavaweb.model.BuildingModel;
import com.laptrinhjavaweb.model.response.BuildingSearchResponse;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.impl.BuildingRepositoryImpl;
import com.laptrinhjavaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService{
	/*@Autowired
	private BuildingRepository buildingRepository;*/
	
   /* @Autowired
	private BuildingConverter buildingConverter;*/
	private BuildingConverter buildingConverter = new BuildingConverter();
	private BuildingRepository buildingRepository = new BuildingRepositoryImpl();

	/*@Override
	public List<BuildingModel> showBuilding(Integer floorArea, String name,Integer numberOfBasement, String street) {
		List<BuildingModel> results = new ArrayList<BuildingModel>();
		List<BuildingEntity> buildingEntities = buildingRepository.findAll();
		for(BuildingEntity item: buildingEntities) {
			BuildingModel buildingModel = new BuildingModel();
			buildingModel.setName(item.getName());
			buildingModel.setFloorArea(item.getFloorarea());	
		    results.add(buildingModel);
		}		

		return results;
	}*/
	
	@Override
	public void save(BuildingModel buildingModel) {
		BuildingEntity buildingEntity = new BuildingEntity();
		buildingEntity.setName(buildingModel.getName());
		buildingEntity.setFloorarea(buildingModel.getFloorArea());
		buildingRepository.insert(buildingEntity);
		
	}

	@Override
	public List<BuildingSearchResponse> getAll(Map<String, Object> params, List<String> types) {
		   List<BuildingSearchResponse> buildings = new ArrayList<>();
					List<BuildingEntity> buildingEntities = buildingRepository.searchBuilding(params,  types);
		            for (BuildingEntity item : buildingEntities ) {
		                BuildingSearchResponse buildingSearchResponse1 = buildingConverter.convertToBuildingSearchResponse(item);
		                buildings.add(buildingSearchResponse1);  

		        }
				return buildings;
	}


	
}