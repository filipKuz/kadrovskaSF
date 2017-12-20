package com.kadrovska.kadrovskasluzba.dto;

public class WorkPlaceDTO {

	private Long workPlaceId;
	private String name;
	private Double coefficient;

	public WorkPlaceDTO() {
	}

	public WorkPlaceDTO(Long workPlaceId, String name, Double coefficient) {
		this.workPlaceId = workPlaceId;
		this.name = name;
		this.coefficient = coefficient;
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
}
