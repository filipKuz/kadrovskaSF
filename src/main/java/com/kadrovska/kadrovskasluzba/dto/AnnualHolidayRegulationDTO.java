package com.kadrovska.kadrovskasluzba.dto;

public class AnnualHolidayRegulationDTO {

	private Long annualHolidayRegulationId;
	private Integer businessYear;
	private Integer numOfDays;
	private EmployeeDTO employeeDTO;

	public AnnualHolidayRegulationDTO() {
		super();
	}

	public AnnualHolidayRegulationDTO(Integer businessYear, Integer numOfDays, EmployeeDTO employeeDTO) {
		this.businessYear = businessYear;
		this.numOfDays = numOfDays;
		this.employeeDTO = employeeDTO;
		
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

	public EmployeeDTO getEmployeeDTO() {
		return employeeDTO;
	}

	public void setEmployeeDTO(EmployeeDTO employeeDTO) {
		this.employeeDTO = employeeDTO;
	}

	
	
	
}
