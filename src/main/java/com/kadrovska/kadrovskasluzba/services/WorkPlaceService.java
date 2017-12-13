package com.kadrovska.kadrovskasluzba.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadrovska.kadrovskasluzba.model.WorkPlace;
import com.kadrovska.kadrovskasluzba.repositories.WorkPlaceJPARepository;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.WorkPlaceInterface;

@Transactional
@Service
public class WorkPlaceService implements WorkPlaceInterface {
	
	@Autowired
	private WorkPlaceJPARepository workPlaceRepository;
	
	@Override
	public WorkPlace findOne(Long id) {
		return workPlaceRepository.findOne(id);
	}
	
	@Override
	public List<WorkPlace> findAll() {
		return workPlaceRepository.findAll();
	}
	
	@Override
	public WorkPlace save(WorkPlace workPlace) {
		return workPlaceRepository.save(workPlace);
	}

}
