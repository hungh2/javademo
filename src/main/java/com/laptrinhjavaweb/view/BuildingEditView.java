package com.laptrinhjavaweb.view;

import com.laptrinhjavaweb.controller.BuildingController;
import com.laptrinhjavaweb.model.BuildingModel;

public class BuildingEditView {

	public static void main(String[] args) {
		BuildingModel buildingModel = new BuildingModel();
		buildingModel.setName("test 1");
		buildingModel.setFloorArea(100);
		BuildingController buildingController = new BuildingController();
		buildingController.save(buildingModel);
	}
}
