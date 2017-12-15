package com.kadrovska.kadrovskasluzba.dto;

import java.sql.Date;

public class VacationRequestDTO {

	private Long vacationRequestId;
	private Date startDate;
	private Date endDate;
	private Integer numOfDays;
	private Long annualHolidayRegulationId;

	public VacationRequestDTO(Long vacationRequestId, Date startDate, Date endDate, Long employeeId, Integer numOfDays,
			Long annualHolidayRegulationId) {
		this.vacationRequestId = vacationRequestId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.numOfDays = numOfDays;
		this.annualHolidayRegulationId = annualHolidayRegulationId;
	}

	public VacationRequestDTO() {
	}

	public Long getVacationRequestId() {
		return vacationRequestId;
	}

	public void setVacationRequestId(Long vRId) {
		this.vacationRequestId = vRId;
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
