package com.kadrovska.kadrovskasluzba.dto;

import java.sql.Date;

import com.kadrovska.kadrovskasluzba.model.Employee;
import com.kadrovska.kadrovskasluzba.model.WorkPlace;

public class WorkHistoryDTO {
	
	private Long wHId;
	private String previousCompany;
	private Date startDate;
	private Date endDate;
	private Long employeeId;
	private Long wPId;
	
	public WorkHistoryDTO() {}

	public WorkHistoryDTO(Long wHId, String previousCompany, Date startDate, Date endDate, Long employeeId
	, Long wPId) {
		super();
		this.wHId = wHId;
		this.previousCompany = previousCompany;
		this.startDate = startDate;
		this.endDate = endDate;
		this.employeeId = employeeId;
		this.wHId = wHId;
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

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getwPId() {
		return wPId;
	}

	public void setwPId(Long wPId) {
		this.wPId = wPId;
	}

	@Override
	public String toString() {
		return "WorkHistoryDTO [wHId=" + wHId + ", previousCompany=" + previousCompany + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", employeeId=" + employeeId + ", wPId=" + wPId + "]";
	}
	
	


	
	
	

}
