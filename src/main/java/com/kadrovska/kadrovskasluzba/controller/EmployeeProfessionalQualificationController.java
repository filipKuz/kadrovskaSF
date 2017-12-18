package com.kadrovska.kadrovskasluzba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kadrovska.kadrovskasluzba.converter.EpqDTOtoEpq;
import com.kadrovska.kadrovskasluzba.converter.EpqtoEpqDTO;
import com.kadrovska.kadrovskasluzba.dto.EmployeeProfessionalQualificationDTO;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.EmployeeProfessionalQualificationServiceInterface;

@Controller
@RequestMapping("/api/employeePQ")
public class EmployeeProfessionalQualificationController {

	@Autowired
	private EmployeeProfessionalQualificationServiceInterface epqsi;

	@Autowired
	private EpqtoEpqDTO toEmployeeProfQualDTO;

	@Autowired
	private EpqDTOtoEpq toEmployeeProdQual;

	@GetMapping
	public ResponseEntity<List<EmployeeProfessionalQualificationDTO>> getEpqs() {
		return new ResponseEntity<>(toEmployeeProfQualDTO.convert(epqsi.findAll()), HttpStatus.OK);
	}
	
	@GetMapping(value = "findByEmployee/{employeeId}")
	public ResponseEntity<List<EmployeeProfessionalQualificationDTO>> getEpqByEmployeeId(@PathVariable("employeeId") Long employeeId) {
		
		return new ResponseEntity<>((toEmployeeProfQualDTO.convert(epqsi.findByEmployeeId(employeeId))), HttpStatus.OK);
	}

}
