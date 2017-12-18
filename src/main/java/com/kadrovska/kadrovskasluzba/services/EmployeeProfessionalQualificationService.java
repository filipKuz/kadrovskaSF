package com.kadrovska.kadrovskasluzba.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadrovska.kadrovskasluzba.model.EmployeeProfessionalQualification;
import com.kadrovska.kadrovskasluzba.repositories.EmployeeProfessionalQualificationJPARepository;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.EmployeeProfessionalQualificationServiceInterface;

@Transactional
@Service
public class EmployeeProfessionalQualificationService implements EmployeeProfessionalQualificationServiceInterface{

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

	@Override
	public List<EmployeeProfessionalQualification> findByEmployeeId(Long id) {
		
		return employeePQRepo.findByEmployeeEmployeeId(id);
	}
	
	
}