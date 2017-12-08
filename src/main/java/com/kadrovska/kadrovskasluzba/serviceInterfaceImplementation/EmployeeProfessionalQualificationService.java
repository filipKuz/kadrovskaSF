package com.kadrovska.kadrovskasluzba.serviceInterfaceImplementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kadrovska.kadrovskasluzba.model.EmployeeProfessionalQualification;
import com.kadrovska.kadrovskasluzba.repositories.EmployeeProfessionalQualificationJPARepository;
import com.kadrovska.kadrovskasluzba.services.EmployeeProfessionalQualificationInterface;

@Transactional
@Service
public class EmployeeProfessionalQualificationService implements EmployeeProfessionalQualificationInterface{

	@Autowired
	private EmployeeProfessionalQualificationJPARepository employeePQRepo;

	@Override
	public EmployeeProfessionalQualification findOne(Long id) {
		return employeePQRepo.findOne(id);
	}

	@Override
	public List<EmployeeProfessionalQualification> findAll() {
		return employeePQRepo.findAll();
	}

	@Override
	public EmployeeProfessionalQualification save(EmployeeProfessionalQualification e) {
		return employeePQRepo.save(e);
	}
	
	
	
	
}
