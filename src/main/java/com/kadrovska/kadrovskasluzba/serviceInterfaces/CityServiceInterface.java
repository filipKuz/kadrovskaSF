package com.kadrovska.kadrovskasluzba.serviceInterfaces;

import java.util.Set;

import com.kadrovska.kadrovskasluzba.model.City;

public interface CityServiceInterface {

	City findOne(Long id);

	Set<City> findAll();

	City save(City city);

	void delete(Long id);
}
