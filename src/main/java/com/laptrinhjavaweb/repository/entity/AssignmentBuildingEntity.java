package com.laptrinhjavaweb.repository.entity;

import com.laptrinhjavaweb.repository.annotation.Column;
import com.laptrinhjavaweb.repository.annotation.Entity;
import com.laptrinhjavaweb.repository.annotation.Table;

@Entity
@Table(name = "assignmentbuilding")
public class AssignmentBuildingEntity extends BaseEntity{
	@Column(name = "staff")
	private Integer staffId;
	
	@Column(name = "buildingid")
	private Integer buildingId;

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}
	
	
}
