package com.kadrovska.kadrovskasluzba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kadrovska.kadrovskasluzba.converter.CityDTOToCity;
import com.kadrovska.kadrovskasluzba.converter.CityToCityDTO;
import com.kadrovska.kadrovskasluzba.dto.CityDTO;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.CityServiceInterface;

@Controller
@RequestMapping("api/cities")
public class CityController {

	@Autowired
	CityServiceInterface cityService;

	@Autowired
	CityDTOToCity CityDTOToCityConverter;

	@Autowired
	CityToCityDTO CityToCityDTOConverter;

	@GetMapping
	public ResponseEntity<List<CityDTO>> getCities() {
		return new ResponseEntity<>(CityToCityDTOConverter.convert(cityService.findAll()), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<CityDTO> getCity(@PathVariable long id) {
		return new ResponseEntity<>(CityToCityDTOConverter.convert(cityService.findOne(id)), HttpStatus.OK);
	}
}