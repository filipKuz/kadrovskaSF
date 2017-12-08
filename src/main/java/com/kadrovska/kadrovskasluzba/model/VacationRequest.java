package com.kadrovska.kadrovskasluzba.model;

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
	
	@Column(nullable=false)
	private Integer numOfDays;
	
	@Column(nullable=false)
	private Boolean approved;
	
	@ManyToOne
	@JoinColumn(name = "employeeId")
	private Employee employee;
	
	public VacationRequest() {}

	public Long getId() {
		return vRId;
	}

	public void setId(Long id) {
		this.vRId = id;
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
