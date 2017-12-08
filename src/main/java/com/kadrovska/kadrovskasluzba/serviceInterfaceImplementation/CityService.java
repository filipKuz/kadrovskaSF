package com.kadrovska.kadrovskasluzba.serviceInterfaceImplementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadrovska.kadrovskasluzba.model.City;
import com.kadrovska.kadrovskasluzba.repositories.CityJPARepository;
import com.kadrovska.kadrovskasluzba.services.CityServiceInterface;


@Transactional
@Service
public class CityService implements CityServiceInterface {

	@Autowired
	CityJPARepository cityRepo;
	
	@Override
	public City findOne(Long id) {
		return cityRepo.findOne(id);
	}

}
