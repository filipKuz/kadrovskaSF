package com.kadrovska.kadrovskasluzba.serviceInterfaces;

import java.util.List;

import com.kadrovska.kadrovskasluzba.model.City;

public interface CityServiceInterface {

	City findOne(Long id);

	List<City> findAll();

	City save(City city);

	void delete(Long id);
}
