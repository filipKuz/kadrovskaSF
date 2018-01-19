package com.kadrovska.kadrovskasluzba.serviceInterfaces;

import java.sql.Date;
import java.util.List;

import com.kadrovska.kadrovskasluzba.model.VacationRequest;

public interface VacationRequestServiceInterface {

	List<VacationRequest> findAll();

	VacationRequest findOne(Long id);

	VacationRequest save(VacationRequest VacationRequest);

	List<VacationRequest> save(List<VacationRequest> VacationRequests);
	
	List<VacationRequest> findByAnnualHolidayRegulationAnnualHolidayRegulationId(Long id);

	void delete(Long id);

	void delete(List<Long> ids);
	
	Date generateEndDate(Date strDate, Integer numOfDays);
}
