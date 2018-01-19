package com.kadrovska.kadrovskasluzba.serviceInterfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.kadrovska.kadrovskasluzba.model.City;

public interface CityServiceInterface {

	City findOne(Long id);

	List<City> findAll();

	City save(City city);

	void delete(Long id);

	Page<City> findAll(PageRequest pageRequest, String searchTerm);
}
