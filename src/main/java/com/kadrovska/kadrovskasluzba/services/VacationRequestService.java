package com.kadrovska.kadrovskasluzba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kadrovska.kadrovskasluzba.model.VacationRequest;
import com.kadrovska.kadrovskasluzba.repositories.VacationRequestJPARepository;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.VacationRequestServiceInterface;

public class VacationRequestService implements VacationRequestServiceInterface{

	@Autowired
	VacationRequestJPARepository vacationRequestJPARepository;
	
	
	@Override
	public List<VacationRequest> findAll() {
		return vacationRequestJPARepository.findAll();
	}
	
	@Override
	public VacationRequest findOne(Long id) {
		return vacationRequestJPARepository.findOne(id);
	}

	@Override
	public VacationRequest save(VacationRequest vacationRequest) {
		return vacationRequestJPARepository.save(vacationRequest);
	}

	@Override
	public List<VacationRequest> save(List<VacationRequest> vacationRequests) {
		return vacationRequestJPARepository.save(vacationRequests);
	}

	@Override
	public void delete(Long id) {
		vacationRequestJPARepository.delete(id);
	}

	@Override
	public void delete(List<Long> ids) {
		// TODO Auto-generated method stub
		
	}

}
