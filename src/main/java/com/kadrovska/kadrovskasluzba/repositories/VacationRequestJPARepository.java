package com.kadrovska.kadrovskasluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kadrovska.kadrovskasluzba.model.VacationRequest;

public interface VacationRequestJPARepository extends JpaRepository<VacationRequest, Long> {

	List<VacationRequest> findByAnnualHolidayRegulationAnnualHolidayRegulationId(Long id);
}
