package com.kadrovska.kadrovskasluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kadrovska.kadrovskasluzba.model.WorkHistory;

public interface WorkHistoryJPARepository extends JpaRepository<WorkHistory, Long>{

	WorkHistory findByEmployeeEmployeeIdAndEndDateIsNull(Long id);
	
	List<WorkHistory> findByEmployeeEmployeeId(Long id);
}
