package com.kadrovska.kadrovskasluzba.dto;

public class ProfessionalQualificationDTO {

	private Long pQId;
	private String name;
	private String qualificationDegree;

	public ProfessionalQualificationDTO() {
	}

	public ProfessionalQualificationDTO(Long pQId, String name, String qualificationDegree) {
		super();
		this.pQId = pQId;
		this.name = name;
		this.qualificationDegree = qualificationDegree;
	}

	public Long getpQId() {
		return pQId;
	}

	public void setpQId(Long pQId) {
		this.pQId = pQId;
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
