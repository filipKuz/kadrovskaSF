package com.kadrovska.kadrovskasluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kadrovska.kadrovskasluzba.model.AnnualHolidayRegulation;

public interface AnnualHolidayRegulationJPARepository extends JpaRepository<AnnualHolidayRegulation,Long> {
	
	List<AnnualHolidayRegulation> findByBusinessYear(Integer year);

}
