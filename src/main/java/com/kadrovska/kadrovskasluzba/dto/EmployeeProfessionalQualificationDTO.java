package com.kadrovska.kadrovskasluzba.dto;

import java.sql.Date;


public class EmployeeProfessionalQualificationDTO {
	
	private Long ePQId;
	private Date dateOfGraduation;
	private String educationalInstitution;
	private String profession;
	
	public EmployeeProfessionalQualificationDTO() {}

	public EmployeeProfessionalQualificationDTO(Long ePQId, Date dateOfGraduation, String educationalInstitution,
			String profession) {
		super();
		this.ePQId = ePQId;
		this.dateOfGraduation = dateOfGraduation;
		this.educationalInstitution = educationalInstitution;
		this.profession = profession;
	}

	public Long getePQId() {
		return ePQId;
	}

	public void setePQId(Long ePQId) {
		this.ePQId = ePQId;
	}

	public Date getDateOfGraduation() {
		return dateOfGraduation;
	}

	public void setDateOfGraduation(Date dateOfGraduation) {
		this.dateOfGraduation = dateOfGraduation;
	}

	public String getEducationalInstitution() {
		return educationalInstitution;
	}

	public void setEducationalInstitution(String educationalInstitution) {
		this.educationalInstitution = educationalInstitution;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	
}
