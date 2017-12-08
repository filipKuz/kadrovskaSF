package com.kadrovska.kadrovskasluzba.dto;

import java.sql.Date;

public class EmployeeChildDTO {

	private Long employeeChildId;
	private String name;
	private String lastName;
	private Date birthDate;
	private String sex;
	private Long parentId;
	
	
	
	public EmployeeChildDTO(String name, String lastName, Date birthDate, String sex,
			Long parentId) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.sex = sex;
		this.parentId = parentId;
	}



	public Long getEmployeeChildId() {
		return employeeChildId;
	}



	public void setEmployeeChildId(Long employeeChildId) {
		this.employeeChildId = employeeChildId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public Date getBirthDate() {
		return birthDate;
	}



	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public Long getParentId() {
		return parentId;
	}



	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}



	@Override
	public String toString() {
		return "EmployeeChildDTO [employeeChildId=" + employeeChildId + ", name=" + name + ", lastName=" + lastName
				+ ", birthDate=" + birthDate + ", sex=" + sex + ", parentId=" + parentId + "]";
	}
	
	
	
	
	
}
