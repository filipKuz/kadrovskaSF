package com.kadrovska.kadrovskasluzba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadrovska.kadrovskasluzba.model.NonworkingDay;
import com.kadrovska.kadrovskasluzba.repositories.NonworkingDayJPARepository;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.NonworkingDayServiceInterface;

@Service
public class NonworkingDayServive implements NonworkingDayServiceInterface {

	@Autowired NonworkingDayJPARepository nonworkingDayRepo;
	
	@Override
	public NonworkingDay findOne(Long id) {
		return nonworkingDayRepo.findOne(id);
	}

	@Override
	public List<NonworkingDay> findAll() {
		return nonworkingDayRepo.findAll();
	}

	@Override
	public NonworkingDay save(NonworkingDay n) {
		return nonworkingDayRepo.save(n);
	}

	@Override
	public void delete(Long id) {
		nonworkingDayRepo.delete(id);
	}
	
	

}
