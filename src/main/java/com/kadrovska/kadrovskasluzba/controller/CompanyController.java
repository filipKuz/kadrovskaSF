package com.kadrovska.kadrovskasluzba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kadrovska.kadrovskasluzba.converter.CompanyDTOToCompany;
import com.kadrovska.kadrovskasluzba.converter.CompanyToCompanyDTO;
import com.kadrovska.kadrovskasluzba.dto.CompanyDTO;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.CompanyServiceInterface;

@Controller
@RequestMapping("api/companies")
public class CompanyController {

	@Autowired
	CompanyServiceInterface companyService;

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
}