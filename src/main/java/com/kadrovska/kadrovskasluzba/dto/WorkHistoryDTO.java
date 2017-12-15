package com.kadrovska.kadrovskasluzba.dto;

import java.sql.Date;

public class WorkHistoryDTO {

	private Long workHistoryId;
	private String previousCompany;
	private Date startDate;
	private Date endDate;
	private Long employeeId;
<<<<<<< HEAD
	private Long workPlaceId;

	public WorkHistoryDTO() {
	}

	public WorkHistoryDTO(Long workHistoryId, String previousCompany, Date startDate, Date endDate, Long employeeId,
			Long workPlaceId) {
		this.workHistoryId = workHistoryId;
=======
	private Long wPId;
	
	public WorkHistoryDTO() {}

	public WorkHistoryDTO(Long wHId, String previousCompany, Date startDate, Date endDate, Long employeeId
	, Long wPId) {
		super();
		this.wHId = wHId;
>>>>>>> 744b6b3e5c276d36e913a1538c61df2848f12468
		this.previousCompany = previousCompany;
		this.startDate = startDate;
		this.endDate = endDate;
		this.employeeId = employeeId;
<<<<<<< HEAD
		this.workPlaceId = workPlaceId;
=======
		this.wHId = wHId;
>>>>>>> 744b6b3e5c276d36e913a1538c61df2848f12468
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
<<<<<<< HEAD
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
=======
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
	
	


	
	
	

>>>>>>> 744b6b3e5c276d36e913a1538c61df2848f12468
}
