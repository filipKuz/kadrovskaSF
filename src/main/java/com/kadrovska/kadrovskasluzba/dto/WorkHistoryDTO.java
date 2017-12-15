package com.kadrovska.kadrovskasluzba.dto;

import java.sql.Date;

public class WorkHistoryDTO {

	private Long workHistoryId;
	private String previousCompany;
	private Date startDate;
	private Date endDate;
	private Long employeeId;
	private Long workPlaceId;

	public WorkHistoryDTO() {
	}

	public WorkHistoryDTO(Long workHistoryId, String previousCompany, Date startDate, Date endDate, Long employeeId,
			Long workPlaceId) {
		this.workHistoryId = workHistoryId;
		this.previousCompany = previousCompany;
		this.startDate = startDate;
		this.endDate = endDate;
		this.employeeId = employeeId;
		this.workPlaceId = workPlaceId;
	}

	public Long getWorkHistoryId() {
		return workHistoryId;
	}

	public void setWorkHistoryId(Long workHistoryId) {
		this.workHistoryId = workHistoryId;
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

	public Long getWorkPlaceId() {
		return workPlaceId;
	}

	public void setWorkPlaceId(Long workPlaceId) {
		this.workPlaceId = workPlaceId;
	}
}