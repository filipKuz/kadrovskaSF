package com.kadrovska.kadrovskasluzba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kadrovska.kadrovskasluzba.converter.AHRDTOtoAHR;
import com.kadrovska.kadrovskasluzba.converter.AHRtoAHRDTO;
import com.kadrovska.kadrovskasluzba.dto.AnnualHolidayRegulationDTO;
import com.kadrovska.kadrovskasluzba.dto.EmployeeDTO;
import com.kadrovska.kadrovskasluzba.model.AnnualHolidayRegulation;
import com.kadrovska.kadrovskasluzba.model.Employee;
import com.kadrovska.kadrovskasluzba.services.AnnualHolidayRegulationService;


@Controller
@RequestMapping("/api/annualHolidayRegulations")
public class AnnualHolidayRegulationController {
	
	@Autowired
	private AHRtoAHRDTO toAhrDTO;
	
	@Autowired
	private AHRDTOtoAHR toAHR;

	@Autowired
	private AnnualHolidayRegulationService annualHolidayRegulationService;
	
	@GetMapping
	public ResponseEntity<List<AnnualHolidayRegulationDTO>> getAnnualHolidayRegulations() {

		return new ResponseEntity<>(toAhrDTO.convert(annualHolidayRegulationService.findAll()), HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<AnnualHolidayRegulationDTO> saveAnnualHolidayRegulation(@RequestBody AnnualHolidayRegulationDTO annualHolidayRegulationDTO) {
		System.out.println(annualHolidayRegulationDTO);
		AnnualHolidayRegulation a = annualHolidayRegulationService.save(toAHR.convert(annualHolidayRegulationDTO));
		System.out.println(a);
		return new ResponseEntity<>(toAhrDTO.convert(a), HttpStatus.OK);
	}
	
	
	
}
