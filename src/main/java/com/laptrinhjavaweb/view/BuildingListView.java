package com.laptrinhjavaweb.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.laptrinhjavaweb.controller.BuildingController;
import com.laptrinhjavaweb.model.response.BuildingSearchResponse;

@SpringBootApplication
public class BuildingListView {

	public static void main(String[] args) {
		

		Map<String,Object> params = new HashMap<>();
		List<String> types = new ArrayList<>();
		initSearchParams(params, types);	
		BuildingController buildingController = new BuildingController();
        for(BuildingSearchResponse item : buildingController.findAll(params, types)) {
          System.out.println( "Building name: "+item.getName()+ " - "
        					+ "Diện tích sàn :"+item.getFloorArea()+ " - "
                			+ "Tên quận :"+item.getDistrict()+ " - "
                			+ "Tên phường :"+item.getWard()+ " - "
                			+ "Tên đường :"+item.getStreet()+ " - "
        					+ "Số tầng hầm :"+item.getNumberOfBasement()+ " - "
        					+ "Hướng :"+item.getDirection()+ " - "
        					+ "Hạng :"+item.getLevel()+ " - "
        					+ "Diện tích thuê từ :"+item.getRentAreaFrom()+ " - "
        					+ "Diện tích thuê đến :"+item.getRentAreaTo()+ " - "
        					+ "Giá thuê từ:"+item.getRentpriceFrom()+ " - "
        					+ "Giá thuê đến:"+item.getRentpriceTo()+ " - "
        					+ "Mã nhân viên :"+item.getStaffId()+ " - "
        					+ "Loại tòa nhà :"+item.getBuildingTypes());
        }
		
	
	}

	private static void initSearchParams(Map<String, Object> params, List<String> types) {
		params.put("name", "ACM Tower");
		params.put("floorArea", 2);
		params.put("street", "96 cao thắng");
		params.put("ward", "Phường 4");
		params.put("numberOfBasement", 2);
		params.put("managerPhone", 234567);
		params.put("managerName", "Le B");
		params.put("level", "");
		params.put("districtCode", "Q1");
		params.put("direction", "");
		params.put("rentPriceFrom", 20);
		params.put("rentPriceTo", null);
		params.put("rentAreaFrom", null);
		params.put("rentAreaTo", 35);
		params.put("staffId", 2);
		
		types.add("TANG_TRET");
		types.add("NGUYEN_CAN");
	}
}







