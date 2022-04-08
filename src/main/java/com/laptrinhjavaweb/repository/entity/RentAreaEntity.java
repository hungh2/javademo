package com.laptrinhjavaweb.repository.entity;

import com.laptrinhjavaweb.repository.annotation.Column;
import com.laptrinhjavaweb.repository.annotation.Entity;
import com.laptrinhjavaweb.repository.annotation.Table;

@Entity
@Table(name = "district")
public class RentAreaEntity {
	@Column(name = "value")
	private Integer value;
	
	@Column(name = "buildingid")
	private Integer buildingId;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}
	
	
}
