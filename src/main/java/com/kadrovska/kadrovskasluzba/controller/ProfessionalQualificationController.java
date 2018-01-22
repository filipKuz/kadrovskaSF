package com.kadrovska.kadrovskasluzba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kadrovska.kadrovskasluzba.converter.ProfessionalQualificationDTOtoProfessioanalQualification;
import com.kadrovska.kadrovskasluzba.converter.ProfessionalQualificationtoProfessioanalQualificationDTO;
import com.kadrovska.kadrovskasluzba.dto.ProfessionalQualificationDTO;
import com.kadrovska.kadrovskasluzba.model.ProfessionalQualification;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.ProfessionalQualificationServiceInterface;

@Component
@RequestMapping("/api/PQ")
public class ProfessionalQualificationController {

	@Autowired
	private ProfessionalQualificationServiceInterface pqService;

	@Autowired
	private ProfessionalQualificationtoProfessioanalQualificationDTO toPQDTO;
	
	@Autowired
	private ProfessionalQualificationDTOtoProfessioanalQualification toPQ;

	@GetMapping
	public ResponseEntity<List<ProfessionalQualificationDTO>> getAllPQs() {
		return new ResponseEntity<>(toPQDTO.convert(pqService.findByActiveTrue()), HttpStatus.OK);
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<?> getPQbyId(@PathVariable("id") Long id) {
		System.out.println(id);
		ProfessionalQualification pq = pqService.findOne(id);
		if(pq == null) {
			return new ResponseEntity<String> ("Can't find Professional qualfication with given id", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ProfessionalQualificationDTO> (toPQDTO.convert(pq), HttpStatus.OK);
	}
	
	@PutMapping(value = "{id}")
	public ResponseEntity<?> editPQ(@Validated @RequestBody ProfessionalQualificationDTO pqDto, @PathVariable("id") Long id, Errors errors) {
		ProfessionalQualification pq = pqService.findOne(id);
		if(errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
			}
		
		if(pq == null) {
			return new ResponseEntity<String> ("Can't find Professional qualfication with given id", HttpStatus.BAD_REQUEST);
		}
		pqDto.setIsActive(true);
		pq.setActive(pqDto.getIsActive());
		pq.setName(pqDto.getName());
		pq.setQualificationDegree(pqDto.getQualificationDegree());
		
		pq = pqService.save(pq);
		
		return new ResponseEntity<ProfessionalQualificationDTO> (toPQDTO.convert(pq), HttpStatus.OK);
	}
	
	@PutMapping(value = "/delete/{id}")
	public ResponseEntity<?> deletePQ(@PathVariable("id") Long id) {
		ProfessionalQualification pq = pqService.findOne(id);
		if(pq == null) {
			return new ResponseEntity<String> ("Can't find Professional qualfication with given id", HttpStatus.BAD_REQUEST);
		}
		pq.setActive(false);
		pq = pqService.save(pq);
		
		return new ResponseEntity<ProfessionalQualificationDTO> (toPQDTO.convert(pq), HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<?> createPQ(@Validated @RequestBody ProfessionalQualificationDTO pqDTO, Errors errors) {
		if(errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
			}
		
		pqDTO.setIsActive(true);
		ProfessionalQualification pq = pqService.save(toPQ.convert(pqDTO));
		return new ResponseEntity<ProfessionalQualificationDTO> (toPQDTO.convert(pq), HttpStatus.OK);
	}
}