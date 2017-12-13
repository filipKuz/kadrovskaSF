package com.kadrovska.kadrovskasluzba.serviceInterfaces;

import java.util.List;

import com.kadrovska.kadrovskasluzba.model.WorkHistory;

public interface WorkHistoryInterface {
	
	List<WorkHistory> findAll();
	
	WorkHistory findOne(Long id);
	
	WorkHistory save(WorkHistory workHistory);

}
