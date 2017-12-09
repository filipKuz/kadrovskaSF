package com.kadrovska.kadrovskasluzba.dto;

import java.sql.Date;

public class EmployeeProfessionalQualificationDTO {

	private Long ePQId;
	private Date dateOfGraduation;
	private String educationalInstitution;
	private String profession;
	private Long professionalQId;
	private Long employeeId;

	public EmployeeProfessionalQualificationDTO() {
	}

	public EmployeeProfessionalQualificationDTO(Long ePQId, Date dateOfGraduation, String educationalInstitution,
			String profession, Long professionalQId, Long employeeId) {
		super();
		this.ePQId = ePQId;
		this.dateOfGraduation = dateOfGraduation;
		this.educationalInstitution = educationalInstitution;
		this.profession = profession;
		this.professionalQId = professionalQId;
		this.employeeId = employeeId;
	}

	public Long getProfessionalQId() {
		return professionalQId;
	}

	public void setProfessionalQId(Long professionalQId) {
		this.professionalQId = professionalQId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
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
