package com.kadrovska.kadrovskasluzba.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	public List<City> findAll() {
		return cityRepo.findAll();
	}

	@Override
	public City save(City city) {
		return cityRepo.save(city);
	}

	@Override
	public void delete(Long id) {
		cityRepo.delete(id);
	}

	@Override
	public Page<City> findAll(PageRequest pageRequest, String searchTerm) {
		return cityRepo.findAll(pageRequest, searchTerm);
	}
}
