package com.kadrovska.kadrovskasluzba.serviceInterfaces;

import java.util.List;

import com.kadrovska.kadrovskasluzba.model.EmployeeProfessionalQualification;

public interface EmployeeProfessionalQualificationServiceInterface {

	EmployeeProfessionalQualification findOne(Long id);

	List<EmployeeProfessionalQualification> findAll();

	EmployeeProfessionalQualification save(EmployeeProfessionalQualification e);
}
