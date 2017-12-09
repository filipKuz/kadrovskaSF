package com.kadrovska.kadrovskasluzba.services;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadrovska.kadrovskasluzba.model.City;
import com.kadrovska.kadrovskasluzba.repositories.CityJPARepository;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.CityServiceInterface;

@Transactional
@Service
public class CityService implements CityServiceInterface {

	@Autowired
	CityJPARepository cityRepo;

	@Override
	public City findOne(Long id) {
		return cityRepo.findOne(id);
	}

	@Override
	public Set<City> findAll() {
		return new HashSet<City>(cityRepo.findAll());
	}

	@Override
	public City save(City city) {
		return cityRepo.save(city);
	}

	@Override
	public void delete(Long id) {
		cityRepo.delete(id);
	}
}
