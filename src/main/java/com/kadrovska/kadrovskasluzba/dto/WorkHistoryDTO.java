package com.kadrovska.kadrovskasluzba.dto;

import java.sql.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

public class WorkHistoryDTO {

	private Long workHistoryId;
	
	@NotBlank(message="Previous Company cannot be empty")
	@Length(max=30, message="Previous Company cannot contain more than 30 characters")
	private String previousCompany;
	
	@NotNull(message="strDate cannot be null")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	
	@NotNull(message="employeeId cannot be null")
	@Min(value=0, message="employeeId must be >= than 0")
	private Long employeeId;
	
	@NotNull(message="workPlaceId cannot be null")
	@Min(value=0, message="workPlaceId must be >= than 0")
	private Long workPlaceId;
	
	private String workPlaceName;
	
	

	public WorkHistoryDTO() {
	}

	public WorkHistoryDTO(Long workHistoryId, String previousCompany, Date startDate, Date endDate, Long employeeId,
			Long workPlaceId , String workPlaceName) {
		this.workHistoryId = workHistoryId;
		this.previousCompany = previousCompany;
		this.startDate = startDate;
		this.endDate = endDate;
		this.employeeId = employeeId;
		this.workPlaceId = workPlaceId;
		this.workPlaceName = workPlaceName;
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
	
	
	

	public String getWorkPlaceName() {
		return workPlaceName;
	}

	public void setWorkPlaceName(String workPlaceName) {
		this.workPlaceName = workPlaceName;
	}

	@Override
	public String toString() {
		return "WorkHistoryDTO [workHistoryId=" + workHistoryId + ", previousCompany=" + previousCompany
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", employeeId=" + employeeId + ", workPlaceId="
				+ workPlaceId + "]";
	}
	
	
}