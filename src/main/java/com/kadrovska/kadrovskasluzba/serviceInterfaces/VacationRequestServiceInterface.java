package com.kadrovska.kadrovskasluzba.serviceInterfaces;

import java.util.List;

import com.kadrovska.kadrovskasluzba.model.VacationRequest;

public interface VacationRequestServiceInterface {

	List<VacationRequest> findAll();

	VacationRequest findOne(Long id);

	VacationRequest save(VacationRequest VacationRequest);

	List<VacationRequest> save(List<VacationRequest> VacationRequests);

	void delete(Long id);

	void delete(List<Long> ids);
}
