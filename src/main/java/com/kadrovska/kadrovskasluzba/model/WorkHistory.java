package com.kadrovska.kadrovskasluzba.model;

import java.sql.Date;

import javax.persistence.ManyToOne;

public class WorkHistory {
	
	private String previousCompany;
	private Date startDate;
	private Date endDate;
	
	@ManyToOne
	private Employee employee;
	
	@ManyToOne
	private WorkPlace workPlace;
	
	public WorkHistory() {}

	public String getPreviousCompany() {
		return previousCompany;
	}

	public void setPreviousCompany(String previousCompany) {
		this.previousCompany = previousCompany;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public WorkPlace getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(WorkPlace workPlace) {
		this.workPlace = workPlace;
	}
	
	

}
