package com.kadrovska.kadrovskasluzba.serviceInterfaces;

import java.util.List;

import com.kadrovska.kadrovskasluzba.model.VacationRequest;
import com.kadrovska.kadrovskasluzba.model.WorkPlace;

public interface WorkPlaceInterface {
	
	List<WorkPlace> findAll();
	
	WorkPlace findOne(Long id);
	
	WorkPlace save(WorkPlace workPlace);

}
