package com.laptrinhjavaweb.repository.entity;

import com.laptrinhjavaweb.repository.annotation.Column;
import com.laptrinhjavaweb.repository.annotation.Entity;
import com.laptrinhjavaweb.repository.annotation.Table;

@Entity
@Table(name = "building")
public class BuildingEntity extends BaseEntity{
	
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "floorarea")
	private Integer floorArea;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "level")
	private String level;
	
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	@Column(name = "numberofbasement")
	private Integer numberOfBasement;
	
	
	@Column(name = "managerName")
	private String managerName;
	
	@Column(name = "managerPhone")
    private Integer managerPhone;
	
	@Column(name = "direction")
    private String direction;
	
	@Column(name = "rentprice")
    private Integer rentprice;
	
	@Column(name = "servicefee")
    private String servicefee;
	
	@Column(name = "ward")
    private String ward;
	
	@Column(name = "districtId")
    private String districtId;
    
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getFloorarea() {
		return floorArea;
	}
	public void setFloorarea(Integer floorarea) {
		this.floorArea = floorarea;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Integer getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(Integer floorArea) {
		this.floorArea = floorArea;
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
	public Integer getRentprice() {
		return rentprice;
	}
	public void setRentprice(Integer rentprice) {
		this.rentprice = rentprice;
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
	public String getDistrictId() {
		return districtId;
	}
	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}
	
	

	
	
	
	
}
