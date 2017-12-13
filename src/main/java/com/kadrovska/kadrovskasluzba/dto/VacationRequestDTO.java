package com.kadrovska.kadrovskasluzba.dto;

import java.sql.Date;

public class VacationRequestDTO {

	private Long vRId;
	private Date strDate;
	private Date endDate;
	private Integer numOfDays;
	private Long annualHolidayRegulationId;

	public VacationRequestDTO(Date strDate, Date endDate, Long employeeId, Integer numOfDays, Long annualHolidayRegulationId) {
		super();
		this.strDate = strDate;
		this.endDate = endDate;
		this.numOfDays = numOfDays;
		this.annualHolidayRegulationId = annualHolidayRegulationId;
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

	public Integer getNumOfDays() {
		return numOfDays;
	}

	public void setNumOfDays(Integer numOfDays) {
		this.numOfDays = numOfDays;
	}

	public Long getAnnualHolidayRegulationId() {
		return annualHolidayRegulationId;
	}

	public void setAnnualHolidayRegulationId(Long annualHolidayRegulationId) {
		this.annualHolidayRegulationId = annualHolidayRegulationId;
	}
	
	
	
}
