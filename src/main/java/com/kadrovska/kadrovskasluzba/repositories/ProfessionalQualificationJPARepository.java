package com.kadrovska.kadrovskasluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kadrovska.kadrovskasluzba.model.ProfessionalQualification;

public interface ProfessionalQualificationJPARepository extends JpaRepository<ProfessionalQualification, Long> {
	
	List<ProfessionalQualification> findByActiveTrue();
}
