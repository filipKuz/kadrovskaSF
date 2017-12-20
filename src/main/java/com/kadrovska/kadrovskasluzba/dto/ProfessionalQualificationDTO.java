package com.kadrovska.kadrovskasluzba.dto;

public class ProfessionalQualificationDTO {

	private Long professionalQualificationId;
	private String name;
	private String qualificationDegree;

	public ProfessionalQualificationDTO() {
	}

	public ProfessionalQualificationDTO(Long professionalQualificationId, String name, String qualificationDegree) {
		this.professionalQualificationId = professionalQualificationId;
		this.name = name;
		this.qualificationDegree = qualificationDegree;
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
}
