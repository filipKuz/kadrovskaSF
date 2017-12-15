package com.kadrovska.kadrovskasluzba.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadrovska.kadrovskasluzba.model.WorkHistory;
import com.kadrovska.kadrovskasluzba.repositories.WorkHistoryJPARepository;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.WorkHistoryServiceInterface;

@Transactional
@Service
public class WorkHistoryService implements WorkHistoryServiceInterface{
	
	
	@Autowired
	public WorkHistoryJPARepository workHistoryRepository;
	
	@Override
	public WorkHistory findOne(Long id) {
		return workHistoryRepository.findOne(id);
	}
	
	@Override
	public List<WorkHistory> findAll() {
		return workHistoryRepository.findAll();
	}

	@Override
	public WorkHistory save(WorkHistory workHistory) {
		return workHistoryRepository.save(workHistory);
	}
}
