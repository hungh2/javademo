package com.laptrinhjavaweb.model.response;

public class BuildingSearchResponse {
	
	private String id;
	private String name;
	private Integer floorArea;
	private String district;
	private String ward;
	private String street;
	private Integer numberOfBasement;
	private String direction;
	private String level;
	private Integer rentArea;
	private Integer rentAreaFrom;
	private Integer rentAreaTo;
	private Integer rentprice;
	private Integer rentpriceFrom;
	private Integer rentpriceTo;
	private String managerName;
    private Integer managerPhone;
	private String staffId;
    //private String type;
    private String servicefee;
    private String user_id;
    private String[] buildingTypes = new String[] {};
   
    

	public Integer getRentArea() {
		return rentArea;
	}

	public void setRentArea(Integer rentArea) {
		this.rentArea = rentArea;
	}

	public Integer getRentprice() {
		return rentprice;
	}

	public void setRentprice(Integer rentprice) {
		this.rentprice = rentprice;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String[] getBuildingTypes() {
		return buildingTypes;
	}

	public void setBuildingTypes(String[] buildingTypes) {
		this.buildingTypes = buildingTypes;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public Integer getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(Integer floorArea) {
		this.floorArea = floorArea;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public Integer getManagerPhone() {
		return managerPhone;
	}

	public void setManagerPhone(Integer managerPhone) {
		this.managerPhone = managerPhone;
	}

	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getServicefee() {
		return servicefee;
	}
	public void setServicefee(String servicefee) {
		this.servicefee = servicefee;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Integer getRentAreaFrom() {
		return rentAreaFrom;
	}

	public void setRentAreaFrom(Integer rentAreaFrom) {
		this.rentAreaFrom = rentAreaFrom;
	}

	public Integer getRentAreaTo() {
		return rentAreaTo;
	}

	public void setRentAreaTo(Integer rentAreaTo) {
		this.rentAreaTo = rentAreaTo;
	}

	public Integer getRentpriceFrom() {
		return rentpriceFrom;
	}

	public void setRentpriceFrom(Integer rentpriceFrom) {
		this.rentpriceFrom = rentpriceFrom;
	}

	public Integer getRentpriceTo() {
		return rentpriceTo;
	}

	public void setRentpriceTo(Integer rentpriceTo) {
		this.rentpriceTo = rentpriceTo;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	
    
}
