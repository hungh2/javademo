package com.laptrinhjavaweb.repository.entity;

import com.laptrinhjavaweb.repository.annotation.Column;
import com.laptrinhjavaweb.repository.annotation.Entity;
import com.laptrinhjavaweb.repository.annotation.Table;

@Entity
@Table(name = "district")
public class DistrictEntity extends BaseEntity{
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "code")
	private String code;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
