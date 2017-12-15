package com.kadrovska.kadrovskasluzba.serviceInterfaces;

import java.util.List;

import com.kadrovska.kadrovskasluzba.model.WorkPlace;

public interface WorkPlaceServiceInterface {
	
	List<WorkPlace> findAll();
	
	WorkPlace findOne(Long id);
	
	WorkPlace save(WorkPlace workPlace);
}
