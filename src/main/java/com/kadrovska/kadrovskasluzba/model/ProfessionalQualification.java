package com.kadrovska.kadrovskasluzba.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class ProfessionalQualification {
	
	private Long id;
	private String name;
	private String qualificationDegree;
	
	@OneToMany
	private Set<EmployeeProfessionalQualification> employees;
	
	public ProfessionalQualification() {}
	
	public Long getID() {
		return id;
	}
	public void setID(Long iD) {
		id = iD;
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
