package com.kadrovska.kadrovskasluzba.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class AnnualHolidayRegulation {
	

	@Id
	@GeneratedValue
	private Long annualHolidayRegulationId;

	@Column(nullable = false)
	private Integer businessYear;

	@Column(nullable = false)
	private Integer numOfDays;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "annualHolidayRegulation")
	private Set<VacationRequest>vacationRequests = new HashSet<>();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="employeeId")
	private Employee employee;

	public AnnualHolidayRegulation() {
		
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

	public Set<VacationRequest> getVacationRequests() {
		return vacationRequests;
	}

	public void setVacationRequests(Set<VacationRequest> vacationRequests) {
		this.vacationRequests = vacationRequests;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
	
	
}
