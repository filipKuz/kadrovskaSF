package com.kadrovska.kadrovskasluzba.dto;

import java.sql.Date;

public class VacationRequestDTO {

	private Long vRId;
	private Date strDate;
	private Date endDate;
	private Boolean approved;
	private Long employeeId;

	public VacationRequestDTO(Date strDate, Date endDate, Boolean approved, Long employeeId) {
		super();
		this.strDate = strDate;
		this.endDate = endDate;
		this.approved = approved;
		this.employeeId = employeeId;
	}

	public VacationRequestDTO() {
		super();
	}

	public Long getvRId() {
		return vRId;
	}

	public void setvRId(Long vRId) {
		this.vRId = vRId;
	}

	public Date getStrDate() {
		return strDate;
	}

	public void setStrDate(Date strDate) {
		this.strDate = strDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "VacationRequestDTO [vRId=" + vRId + ", strDate=" + strDate + ", endDate=" + endDate + ", approved="
				+ approved + ", employeeId=" + employeeId + "]";
	}
}
