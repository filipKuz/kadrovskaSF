package com.kadrovska.kadrovskasluzba.services;

import java.util.List;

import com.kadrovska.kadrovskasluzba.model.VacationRequest;

public interface VacationRequestService {
	
	VacationRequest findAll();
	
	VacationRequest findOne(Long id);
	
	VacationRequest save(VacationRequest VacationRequest);
	
	List<VacationRequest> save(List<VacationRequest> VacationRequests);
	
	VacationRequest delete(Long id);
	
	void delete(List<Long> ids);
}