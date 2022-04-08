package com.laptrinhjavaweb.repository.entity;

import com.laptrinhjavaweb.repository.annotation.Column;
import com.laptrinhjavaweb.repository.annotation.Entity;
import com.laptrinhjavaweb.repository.annotation.Table;

@Entity
@Table(name = "building")
public class CustomerEntity extends BaseEntity {

	
	@Column(name = "fullname")
	private String fullName;
	
	@Column(name = "phone")
	private String phone;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

	
	
}
