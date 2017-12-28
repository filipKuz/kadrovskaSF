package com.kadrovska.kadrovskasluzba.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class EmployeeProfessionalQualification {

	@Id
	@GeneratedValue
	private Long ePQId;

	@Column(nullable = false)
	private Date dateOfGraduation;

	@Column(nullable = false, columnDefinition="VARCHAR(30)")
	private String educationalInstitution;

	@Column(nullable = false, columnDefinition="VARCHAR(30)")
	private String profession;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pQId", nullable=false)
	private ProfessionalQualification professionalQualification;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employeeId", nullable=false)
	private Employee employee;

	public EmployeeProfessionalQualification() {
	}

	public Long getID() {
		return ePQId;
	}

	public void setID(Long iD) {
		ePQId = iD;
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

	@Override
	public String toString() {
		return "EmployeeProfessionalQualification [ePQId=" + ePQId + ", dateOfGraduation=" + dateOfGraduation
				+ ", educationalInstitution=" + educationalInstitution + ", profession=" + profession
				+ ", professionalQualification=" + professionalQualification + ", employee=" + employee + "]";
	}
	
	
}
