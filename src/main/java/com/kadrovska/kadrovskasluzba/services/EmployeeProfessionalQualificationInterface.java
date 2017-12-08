package com.kadrovska.kadrovskasluzba.services;

import java.util.List;

import com.kadrovska.kadrovskasluzba.model.EmployeeProfessionalQualification;


public interface EmployeeProfessionalQualificationInterface {
	EmployeeProfessionalQualification findOne(Long id);
	List<EmployeeProfessionalQualification> findAll();
	EmployeeProfessionalQualification save(EmployeeProfessionalQualification e); 
}
