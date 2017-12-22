package com.kadrovska.kadrovskasluzba.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class VacationRequest {

	@Id
	@GeneratedValue
	private Long vRId;

	@Column(nullable = false)
	private Date strDate;

	@Column(nullable = false)
	private Date endDate;

	@Column(nullable = false)
	private Integer numOfDays;

	@ManyToOne
	@JoinColumn(name = "annualHolidayRegulationId")
	private AnnualHolidayRegulation annualHolidayRegulation;

	public VacationRequest() {
	}

	public Long getId() {
		return vRId;
	}

	public void setId(Long id) {
		this.vRId = id;
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

	public AnnualHolidayRegulation getAnnualHolidayRegulation() {
		return annualHolidayRegulation;
	}

	public void setAnnualHolidayRegulation(AnnualHolidayRegulation annualHolidayRegulation) {
		this.annualHolidayRegulation = annualHolidayRegulation;
	}

	public Integer getNumOfDays() {
		return numOfDays;
	}

	public void setNumOfDays(Integer numOfDays) {
		this.numOfDays = numOfDays;
	}

}
