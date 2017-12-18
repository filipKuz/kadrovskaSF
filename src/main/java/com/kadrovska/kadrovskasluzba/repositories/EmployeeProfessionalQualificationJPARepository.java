package com.kadrovska.kadrovskasluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kadrovska.kadrovskasluzba.model.EmployeeProfessionalQualification;

public interface EmployeeProfessionalQualificationJPARepository
		extends JpaRepository<EmployeeProfessionalQualification, Long> {
	
	
	List<EmployeeProfessionalQualification> findByEmployeeEmployeeId(Long id);

}
