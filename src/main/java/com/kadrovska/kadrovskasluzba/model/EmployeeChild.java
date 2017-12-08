package com.kadrovska.kadrovskasluzba.model;

import java.sql.Date;

import javax.persistence.ManyToOne;

public class EmployeeChild {

	private Long id;
	private String name;
	private String lastName;
	private Date birthDate;
	private Sex sex;
	
	@ManyToOne
	private Employee parent;

	public EmployeeChild() {
	}

	public Long getID() {
		return id;
	}

	public void setID(Long iD) {
		id = iD;
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

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Employee getParent() {
		return parent;
	}

	public void setParent(Employee parent) {
		this.parent = parent;
	}
	

}
