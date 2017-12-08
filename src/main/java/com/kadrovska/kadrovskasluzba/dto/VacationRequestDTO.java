package com.kadrovska.kadrovskasluzba.dto;

public class VacationRequestDTO {
	
	private Long vRId;
	private Integer numOfDays;
	private Boolean approved;
	private Long employeeId;
	
	
	
	public VacationRequestDTO(Integer numOfDays, Boolean approved, Long employeeId) {
		super();
		this.numOfDays = numOfDays;
		this.approved = approved;
		this.employeeId = employeeId;
	}



	public Long getvRId() {
		return vRId;
	}



	public void setvRId(Long vRId) {
		this.vRId = vRId;
	}



	public Integer getNumOfDays() {
		return numOfDays;
	}



	public void setNumOfDays(Integer numOfDays) {
		this.numOfDays = numOfDays;
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
		return "VacationRequestDTO [vRId=" + vRId + ", numOfDays=" + numOfDays + ", approved=" + approved
				+ ", employeeId=" + employeeId + "]";
	}
	
	

}
