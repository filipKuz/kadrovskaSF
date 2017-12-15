package com.kadrovska.kadrovskasluzba.dto;

public class AnnualHolidayRegulationDTO {

	private Long annualHolidayRegulationId;
	private Integer businessYear;
	private Integer numOfDays;
	private Long employeeId;

	public AnnualHolidayRegulationDTO() {
		super();
	}

	public AnnualHolidayRegulationDTO(Integer businessYear, Integer numOfDays, Long employeeId) {
		this.businessYear = businessYear;
		this.numOfDays = numOfDays;
		this.employeeId = employeeId;
	}

	public Long getAnnualHolidayRegulationId() {
		return annualHolidayRegulationId;
	}

	public void setAnnualHolidayRegulationId(Long annualHolidayRegulationId) {
		this.annualHolidayRegulationId = annualHolidayRegulationId;
	}

	public Integer getBusinessYear() {
		return businessYear;
	}

	public void setBusinessYear(Integer businessYear) {
		this.businessYear = businessYear;
	}

	public Integer getNumOfDays() {
		return numOfDays;
	}

	public void setNumOfDays(Integer numOfDays) {
		this.numOfDays = numOfDays;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
}
