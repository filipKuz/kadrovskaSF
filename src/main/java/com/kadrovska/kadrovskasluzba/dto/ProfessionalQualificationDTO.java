package com.kadrovska.kadrovskasluzba.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class ProfessionalQualificationDTO {

	private Long professionalQualificationId;
	

	@NotBlank(message="Name cannot be empty")
	@Length(max=30, message="Name cannot contain more than 30 characters")
	private String name;
	
	@NotBlank(message="qualificationDegree cannot be empty")
	@Length(max=30, message="qualificationDegree cannot contain more than 30 characters")
	private String qualificationDegree;
	
	private Boolean isActive;
	
	public ProfessionalQualificationDTO() {
	}

	public ProfessionalQualificationDTO(Long professionalQualificationId, String name, String qualificationDegree, Boolean isActive) {
		this.professionalQualificationId = professionalQualificationId;
		this.name = name;
		this.qualificationDegree = qualificationDegree;
		this.isActive = isActive;
	}

	public Long getProfessionalQualificationId() {
		return professionalQualificationId;
	}

	public void setProfessionalQualificationId(Long professionalQualificationId) {
		this.professionalQualificationId = professionalQualificationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQualificationDegree() {
		return qualificationDegree;
	}

	public void setQualificationDegree(String qualificationDegree) {
		this.qualificationDegree = qualificationDegree;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	
}
