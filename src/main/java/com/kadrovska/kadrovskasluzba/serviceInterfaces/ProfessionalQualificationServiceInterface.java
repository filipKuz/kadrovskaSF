package com.kadrovska.kadrovskasluzba.serviceInterfaces;

import java.util.List;

import com.kadrovska.kadrovskasluzba.model.ProfessionalQualification;

public interface ProfessionalQualificationServiceInterface {

	ProfessionalQualification findOne(Long id);
	
	List<ProfessionalQualification> findAll();

}
