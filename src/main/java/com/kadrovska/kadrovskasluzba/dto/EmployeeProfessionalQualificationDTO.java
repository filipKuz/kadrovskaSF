package com.kadrovska.kadrovskasluzba.dto;

import java.sql.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

public class EmployeeProfessionalQualificationDTO {

	private Long ePQId;
	
	@NotNull(message="Birth date cannot be null")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateOfGraduation;
	
	@NotBlank(message="educationalInstitution cannot be empty")
	@Length(max=30, message="educationalInstitution cannot contain more than 30 characters")
	private String educationalInstitution;
	
	@NotBlank(message="profession cannot be empty")
	@Length(max=30, message="profession cannot contain more than 30 characters")
	private String profession;
	
	private ProfessionalQualificationDTO professionalQId;
	
	@NotNull(message="employeeId cannot be null")
	@Min(value=0, message="employeeId must be >= than 0")
	private Long employeeId;

	public EmployeeProfessionalQualificationDTO() {
	}

	public EmployeeProfessionalQualificationDTO(Long ePQId, Date dateOfGraduation, String educationalInstitution,
			String profession, ProfessionalQualificationDTO professionalQId, Long employeeId) {
		this.ePQId = ePQId;
		this.dateOfGraduation = dateOfGraduation;
		this.educationalInstitution = educationalInstitution;
		this.profession = profession;
		this.professionalQId = professionalQId;
		this.employeeId = employeeId;
	}


	public ProfessionalQualificationDTO getProfessionalQId() {
		return professionalQId;
	}

	public void setProfessionalQId(ProfessionalQualificationDTO professionalQId) {
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

	@Override
	public String toString() {
		return "EmployeeProfessionalQualificationDTO [ePQId=" + ePQId + ", dateOfGraduation=" + dateOfGraduation
				+ ", educationalInstitution=" + educationalInstitution + ", profession=" + profession
				+ ", professionalQId=" + professionalQId + ", employeeId=" + employeeId + "]";
	}
	
	
}
