package com.kadrovska.kadrovskasluzba.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ProfessionalQualification {

	@Id
	@GeneratedValue
	private Long pQId;

	@Column(nullable = false, columnDefinition="VARCHAR(30)")
	private String name;

	@Column(nullable = false, columnDefinition="VARCHAR(30)")
	private String qualificationDegree;

	@Column(nullable = false)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "professionalQualification")
	private Set<EmployeeProfessionalQualification> employeesPQ = new HashSet<>();

	public ProfessionalQualification() {
	}

	public Long getID() {
		return pQId;
	}

	public void setID(Long iD) {
		pQId = iD;
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

	public Long getpQId() {
		return pQId;
	}

	public void setpQId(Long pQId) {
		this.pQId = pQId;
	}

	public Set<EmployeeProfessionalQualification> getEmployeesPQ() {
		return employeesPQ;
	}

	public void setEmployeesPQ(Set<EmployeeProfessionalQualification> employeesPQ) {
		this.employeesPQ = employeesPQ;
	}
	
	
}
