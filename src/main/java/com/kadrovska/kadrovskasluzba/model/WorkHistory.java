package com.kadrovska.kadrovskasluzba.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class WorkHistory {

	@Id
	@GeneratedValue
	private Long wHId;

	private String previousCompany;

	@Column(nullable = false)
	private Date startDate;

	private Date endDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employeeId")
	private Employee employee;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "wPId")
	private WorkPlace workPlace;

	public WorkHistory() {
	}

	public Long getwHId() {
		return wHId;
	}

	public void setwHId(Long wHId) {
		this.wHId = wHId;
	}

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
