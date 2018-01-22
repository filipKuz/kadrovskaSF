package com.kadrovska.kadrovskasluzba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kadrovska.kadrovskasluzba.converter.CompanyDTOToCompany;
import com.kadrovska.kadrovskasluzba.converter.CompanyToCompanyDTO;
import com.kadrovska.kadrovskasluzba.dto.CompanyDTO;
import com.kadrovska.kadrovskasluzba.model.Company;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.CityServiceInterface;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.CompanyServiceInterface;

@Controller
@RequestMapping("api/companies")
public class CompanyController {

	@Autowired
	CompanyServiceInterface companyService;

	@Autowired
	CityServiceInterface cityService;

	@Autowired
	CompanyDTOToCompany companyDTOToCompanyConverter;

	@Autowired
	CompanyToCompanyDTO companyToCompanyDTOConverter;

	@GetMapping
	public ResponseEntity<List<CompanyDTO>> getCompanies() {
		return new ResponseEntity<>(companyToCompanyDTOConverter.convert(companyService.findAll()), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<CompanyDTO> getCompany(@PathVariable long id) {
		return new ResponseEntity<>(companyToCompanyDTOConverter.convert(companyService.findOne(id)), HttpStatus.OK);
	}

	@GetMapping(path = "/ours")
	public ResponseEntity<CompanyDTO> getOurCompany() {
		return new ResponseEntity<>(companyToCompanyDTOConverter.convert(companyService.findByIsOursTrue()),
				HttpStatus.OK);
	}

	@PutMapping(value = "{id}")
	public ResponseEntity<?> editCompany(@RequestBody CompanyDTO companyDTO, @PathVariable("id") Long id) {
		Company company = companyService.findOne(id);
		if (company == null) {
			return new ResponseEntity<String>("Can't find company with given id", HttpStatus.BAD_REQUEST);
		}
		company.setName(companyDTO.getName());
		company.setVat(companyDTO.getVat());
		if (companyDTO.getEmail() != "" && companyDTO.getEmail() != null) {
			company.setEmail(companyDTO.getEmail());
		}
		if (companyDTO.getPhoneNumber() != "" && companyDTO.getPhoneNumber() != null) {
			company.setPhoneNumber(companyDTO.getPhoneNumber());
		}
		if (companyDTO.getAddress() != "" && companyDTO.getAddress() != null) {
			company.setAddress(companyDTO.getAddress());
		}
		company.setCity(cityService.findOne(companyDTO.getCityId()));
		companyService.save(company);

		return new ResponseEntity<CompanyDTO>(companyToCompanyDTOConverter.convert(company), HttpStatus.OK);
	};
}