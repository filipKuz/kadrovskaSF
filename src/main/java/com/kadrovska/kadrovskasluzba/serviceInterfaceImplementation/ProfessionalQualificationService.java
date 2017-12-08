package com.kadrovska.kadrovskasluzba.serviceInterfaceImplementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadrovska.kadrovskasluzba.model.ProfessionalQualification;
import com.kadrovska.kadrovskasluzba.repositories.ProfessionalQualificationJPARepository;
import com.kadrovska.kadrovskasluzba.services.ProfessionalQualificationServiceInterface;

@Transactional
@Service
public class ProfessionalQualificationService implements ProfessionalQualificationServiceInterface {

	@Autowired
	private ProfessionalQualificationJPARepository pQrepo;
	
	@Override
	public ProfessionalQualification findOne(Long id) {
		return pQrepo.findOne(id);
	}

}
