package com.kadrovska.kadrovskasluzba.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class WorkPlace {

	@Id
	@GeneratedValue
	private Long workPlaceId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private Double coefficient;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "workPlace")
	private Set<WorkHistory> workHistory = new HashSet<>();

	public WorkPlace() {
	}

	public Long getWorkPlaceId() {
		return workPlaceId;
	}

	public void setWorkPlaceId(Long workPlaceId) {
		this.workPlaceId = workPlaceId;
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
