package com.laptrinhjavaweb.utils;

import java.util.HashMap;
import java.util.Map;

import com.laptrinhjavaweb.constant.BuildingTypeConstant;

public class BuildingTypeUtils {
	
	public static Map<String, String> getBuildingType() {
		Map<String, String> result = new HashMap<>();
		result.put(BuildingTypeConstant.TANG_TRET_CODE, BuildingTypeConstant.TANG_TRET);
		result.put(BuildingTypeConstant.NGUYEN_CAN_CODE, BuildingTypeConstant.NGUYEN_CAN);
		result.put(BuildingTypeConstant.NOI_THAT_CODE, BuildingTypeConstant.NOI_THAT);
		return result;
	}
	
}
	