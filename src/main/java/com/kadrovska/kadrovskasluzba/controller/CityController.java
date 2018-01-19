package com.kadrovska.kadrovskasluzba.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kadrovska.kadrovskasluzba.converter.CityDTOToCity;
import com.kadrovska.kadrovskasluzba.converter.CityToCityDTO;
import com.kadrovska.kadrovskasluzba.dto.CityDTO;
import com.kadrovska.kadrovskasluzba.model.City;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.CityServiceInterface;

@Controller
@RequestMapping("api/cities")
public class CityController {

	@Autowired
	CityServiceInterface cityService;

	@Autowired
	CityDTOToCity cityDTOToCityConverter;

	@Autowired
	CityToCityDTO cityToCityDTOConverter;

	@GetMapping(path = "/all")
	public ResponseEntity<List<CityDTO>> getCities() {
		return new ResponseEntity<>(cityToCityDTOConverter.convert(cityService.findAll()), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<CityDTO> getCity(@PathVariable long id) {
		return new ResponseEntity<>(cityToCityDTOConverter.convert(cityService.findOne(id)), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<CityDTO>> getCities(@RequestParam("page") int page, @RequestParam("size") int size,
			@RequestParam("searchTerm") String searchTerm, @RequestParam("sortTerm") String sortTerm,
			@RequestParam("sortDirection") String sortDir) {

		Sort sort = new Sort("cityId");

		if (sortDir.equals("ASC")) {
			sort = new Sort(Sort.Direction.ASC, sortTerm);
		} else if (sortDir.equals("DESC")) {
			sort = new Sort(Sort.Direction.DESC, sortTerm);
		}
		Page<City> cities = cityService.findAll(new PageRequest(page, size, sort), searchTerm);
		System.out.println(searchTerm);
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(cities.getTotalPages()));
		headers.add("access-control-expose-headers", "totalPages");
		return new ResponseEntity<>(cityToCityDTOConverter.convert(cities.getContent()), headers, HttpStatus.OK);
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<CityDTO> saveCity(@RequestBody Map<String, Object> data) {
		ObjectMapper mapper = new ObjectMapper();
		
		System.out.println("OVO JE REQUEST BODy");
		System.out.println(data);
		System.out.println("");		
		
		CityDTO cityDTO = mapper.convertValue(data.get("City"), CityDTO.class);
		
		System.out.println("Ovo je cityDTO u kontroleru");
		System.out.println(cityDTO.getCityId() + " " + cityDTO.getCityName() + " " + cityDTO.getZipCode());
		System.out.println(" ");
		
		City city = cityService.save(cityDTOToCityConverter.convert(cityDTO));
		
		

		return new ResponseEntity<>(cityToCityDTOConverter.convert(city), HttpStatus.OK);
	}

	@PutMapping(value = "{id}")
	public ResponseEntity<?> editCity(@RequestBody CityDTO cityDTO, @PathVariable("id") Long id) {
		City city = cityService.findOne(id);
		if (city == null) {
			return new ResponseEntity<String>("Can't find city with given id", HttpStatus.BAD_REQUEST);
		}

		city.setCityName(cityDTO.getCityName());
		city.setZipCode(cityDTO.getZipCode());

		cityService.save(city);

		return new ResponseEntity<CityDTO>(cityToCityDTOConverter.convert(city), HttpStatus.OK);
	};
}