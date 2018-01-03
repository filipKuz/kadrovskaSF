package com.kadrovska.kadrovskasluzba.serviceInterfaces;

import java.util.List;

import com.kadrovska.kadrovskasluzba.model.NonworkingDay;

public interface NonworkingDayServiceInterface {

	NonworkingDay findOne(Long id);

	List<NonworkingDay> findAll();

	NonworkingDay save(NonworkingDay n);
	
	void delete(Long id);
}