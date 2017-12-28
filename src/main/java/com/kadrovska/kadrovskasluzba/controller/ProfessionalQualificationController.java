package com.kadrovska.kadrovskasluzba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kadrovska.kadrovskasluzba.converter.ProfessionalQualificationtoProfessioanalQualificationDTO;
import com.kadrovska.kadrovskasluzba.dto.ProfessionalQualificationDTO;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.ProfessionalQualificationServiceInterface;

@Component
@RequestMapping("/api/PQ")
public class ProfessionalQualificationController {

	@Autowired
	private ProfessionalQualificationServiceInterface pqService;

	@Autowired
	private ProfessionalQualificationtoProfessioanalQualificationDTO toPQDTO;

	@GetMapping
	public ResponseEntity<List<ProfessionalQualificationDTO>> getAllPQs() {

		return new ResponseEntity<>(toPQDTO.convert(pqService.findAll()), HttpStatus.OK);
	}
}