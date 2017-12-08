package com.kadrovska.kadrovskasluzba.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class VacationRequest {

	private Long id;
	private Integer numOfDays;
	private Boolean approved;
	@OneToMany
	private Employee employee;
	
	public VacationRequest() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	

}
