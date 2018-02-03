package com.kadrovska.kadrovskasluzba.serviceInterfaces;

import java.util.List;

import com.kadrovska.kadrovskasluzba.model.EmployeeProfessionalQualification;
import com.kadrovska.kadrovskasluzba.model.WorkHistory;

public interface WorkHistoryServiceInterface {
	
	List<WorkHistory> findAll();
	
	WorkHistory findOne(Long id);
	
	void delete(Long id);
	
	void delete(WorkHistory workHistory);
	
	WorkHistory save(WorkHistory workHistory);
	
	WorkHistory findByEmployeeEmployeeIdAndEndDateIsNull(Long id);

	List<WorkHistory> findByEmployeeId(Long id);

}
