package com.kadrovska.kadrovskasluzba.serviceInterfaces;

import java.util.List;

import com.kadrovska.kadrovskasluzba.model.AnnualHolidayRegulation;

public interface AnnualHolidayRegulationServiceInterface {

	AnnualHolidayRegulation findOne(Long id);

	List<AnnualHolidayRegulation> findAll();

	AnnualHolidayRegulation save(AnnualHolidayRegulation annualHolidayRegulation);

	void delete(Long id);
	
}
