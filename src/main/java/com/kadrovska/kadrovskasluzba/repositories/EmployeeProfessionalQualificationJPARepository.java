package com.kadrovska.kadrovskasluzba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kadrovska.kadrovskasluzba.model.EmployeeProfessionalQualification;

public interface EmployeeProfessionalQualificationJPARepository
		extends JpaRepository<EmployeeProfessionalQualification, Long> {

}
