package com.kadrovska.kadrovskasluzba.model;

import java.sql.Date;

import javax.persistence.ManyToOne;

public class EmployeeProfessionalQualification {
	
		
	private Long id;
	private Date dateOfGraduation;
	private String educationalInstitution;
	private String profession;
	@ManyToOne
	private ProfessionalQualification professionalQualification;
	@ManyToOne
	private Employee employee;
	
	public EmployeeProfessionalQualification() {}
	
	public Long getID() {
		return id;
	}
	public void setID(Long iD) {
		id = iD;
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

	public ProfessionalQualification getProfessionalQualification() {
		return professionalQualification;
	}

	public void setProfessionalQualification(ProfessionalQualification professionalQualification) {
		this.professionalQualification = professionalQualification;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
}
