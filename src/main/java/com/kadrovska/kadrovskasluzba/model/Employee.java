package com.kadrovska.kadrovskasluzba.model;

import java.sql.Date;

public class Employee {
	
	private Long ID;
	private String lastName;
	private String firstName;
	private String parentName;
	private String madenName;
	private Date birthDate;
	private Sex sex;
	private String address;
	private Integer numberOfVacationDays;
	
	public Employee() {}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getMadenName() {
		return madenName;
	}

	public void setMadenName(String madenName) {
		this.madenName = madenName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getNumberOfVacationDays() {
		return numberOfVacationDays;
	}

	public void setNumberOfVacationDays(Integer numberOfVacationDays) {
		this.numberOfVacationDays = numberOfVacationDays;
	}

	
}
