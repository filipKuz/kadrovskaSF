package com.kadrovska.kadrovskasluzba.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class WorkPlaceDTO {

	private Long workPlaceId;
	
	@NotBlank(message="Name cannot be empty")
	@Length(max=30, message="Name cannot contain more than 30 characters")
	private String name;
	
	@NotNull(message="coefficient cannot be null")
	@Min(value=0, message="employeeId must be >= than 0")
	private Double coefficient;
	
	
	private Integer extraVacationDays;

	public WorkPlaceDTO() {
	}

	public WorkPlaceDTO(Long workPlaceId, String name, Double coefficient , Integer extraVacationDays) {
		this.workPlaceId = workPlaceId;
		this.name = name;
		this.coefficient = coefficient;
		this.extraVacationDays = extraVacationDays;
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

	public Integer getExtraVacationDays() {
		return extraVacationDays;
	}

	public void setExtraVacationDays(Integer extraVacationDays) {
		this.extraVacationDays = extraVacationDays;
	}
	
}
