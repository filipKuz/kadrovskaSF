package com.kadrovska.kadrovskasluzba.dto;

import java.sql.Date;

import com.kadrovska.kadrovskasluzba.model.Employee;
import com.kadrovska.kadrovskasluzba.model.WorkPlace;

public class WorkHistoryDTO {
	
	private Long wHId;
	private String previousCompany;
	private Date startDate;
	private Date endDate;
	private Employee employee;
	private WorkPlace workPlace;
	
	public WorkHistoryDTO() {}

	public WorkHistoryDTO(Long wHId, String previousCompany, Date startDate, Date endDate, Employee employee,
			WorkPlace workPlace) {
		super();
		this.wHId = wHId;
		this.previousCompany = previousCompany;
		this.startDate = startDate;
		this.endDate = endDate;
		this.employee = employee;
		this.workPlace = workPlace;
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

	@Override
	public String toString() {
		return "WorkHistoryDTO [wHId=" + wHId + ", previousCompany=" + previousCompany + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", employee=" + employee + ", workPlace=" + workPlace + "]";
	}
	
	
	
	

}
