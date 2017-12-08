package com.kadrovska.kadrovskasluzba.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
@Entity
public class WorkPlace {
	
	private Long id;
	private String name;
	private Double coefficient;
	
	@OneToMany
	private Set<WorkHistory> workHistory;
	
	
	public WorkPlace() {}
	
	public Long getWorkplaceId() {
		return id;
	}
	public void setWorkplaceId(Long workplaceId) {
		this.id = workplaceId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(Double coefficient) {
		this.coefficient = coefficient;
	}

	public Set<WorkHistory> getWorkHistory() {
		return workHistory;
	}

	public void setWorkHistory(Set<WorkHistory> workHistory) {
		this.workHistory = workHistory;
	}
	
	
	

}
