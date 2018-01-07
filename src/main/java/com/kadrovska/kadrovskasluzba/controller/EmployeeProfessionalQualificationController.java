package com.kadrovska.kadrovskasluzba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kadrovska.kadrovskasluzba.converter.EpqtoEpqDTO;
import com.kadrovska.kadrovskasluzba.dto.EmployeeProfessionalQualificationDTO;
import com.kadrovska.kadrovskasluzba.model.Employee;
import com.kadrovska.kadrovskasluzba.model.EmployeeProfessionalQualification;
import com.kadrovska.kadrovskasluzba.model.ProfessionalQualification;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.EmployeeProfessionalQualificationServiceInterface;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.EmployeeServiceInterface;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.ProfessionalQualificationServiceInterface;

@Controller
@RequestMapping("/api/employeePQ")
public class EmployeeProfessionalQualificationController {

	@Autowired
	private EmployeeProfessionalQualificationServiceInterface epqService;
	
	@Autowired
	private ProfessionalQualificationServiceInterface professionalServiceI;
	
	@Autowired
	private EmployeeServiceInterface employeeServiceInterface;

	@Autowired
	private EpqtoEpqDTO toEmployeeProfQualDTO;

	@GetMapping
	public ResponseEntity<List<EmployeeProfessionalQualificationDTO>> getEpqs() {
		return new ResponseEntity<>(toEmployeeProfQualDTO.convert(epqService.findAll()), HttpStatus.OK);
	}
	
	@GetMapping(value = "findById/{id}")
	public ResponseEntity<?> getEpqById(
			@PathVariable("id") Long id) {
		
		EmployeeProfessionalQualification epq = epqService.findOne(id);
		if (epq == null) {
			return new ResponseEntity<String> ("Bad parameters", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>((toEmployeeProfQualDTO.convert(epq)), HttpStatus.OK);
	}

	@GetMapping(value = "findByEmployee/{employeeId}")
	public ResponseEntity<List<EmployeeProfessionalQualificationDTO>> getEpqByEmployeeId(
			@PathVariable("employeeId") Long employeeId) {

		return new ResponseEntity<>((toEmployeeProfQualDTO.convert(epqService.findByEmployeeId(employeeId))),
				HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> createEpq(@RequestBody EmployeeProfessionalQualificationDTO epqDTO) {
		
		System.out.println(epqDTO);
		Employee e = employeeServiceInterface.findOne(epqDTO.getEmployeeId());
		ProfessionalQualification pq = professionalServiceI.findOne(epqDTO.getProfessionalQId().getProfessionalQualificationId());
		if (e==null || pq ==null) {
			return new ResponseEntity<String> ("Bad parameters", HttpStatus.BAD_REQUEST);
		}
		
		EmployeeProfessionalQualification epq = new EmployeeProfessionalQualification();
		epq.setDateOfGraduation(epqDTO.getDateOfGraduation());
		epq.setEducationalInstitution(epqDTO.getEducationalInstitution());
		epq.setProfessionalQualification(pq);
		epq.setEmployee(e);
		epq.setProfession(epqDTO.getProfession());
		epq = epqService.save(epq);
		
		return new ResponseEntity<EmployeeProfessionalQualificationDTO> (toEmployeeProfQualDTO.convert(epq), HttpStatus.OK);
	}
	
	@PutMapping(value="{id}")
	public ResponseEntity<?> editEpq(@RequestBody EmployeeProfessionalQualificationDTO epqDTO,
									 @PathVariable("id") Long id) {
		Employee e = employeeServiceInterface.findOne(epqDTO.getEmployeeId());
		ProfessionalQualification pq = professionalServiceI.findOne(epqDTO.getProfessionalQId().getProfessionalQualificationId());
		EmployeeProfessionalQualification epq = epqService.findOne(id);
		if (e==null || pq ==null || epq ==null) {
			return new ResponseEntity<String> ("Bad parameters", HttpStatus.BAD_REQUEST);
		}
		
		epq.setDateOfGraduation(epqDTO.getDateOfGraduation());
		epq.setEducationalInstitution(epqDTO.getEducationalInstitution());
		epq.setProfessionalQualification(pq);
		epq.setEmployee(e);
		epq.setProfession(epqDTO.getProfession());
		epq = epqService.save(epq);
		return new ResponseEntity<EmployeeProfessionalQualificationDTO> (toEmployeeProfQualDTO.convert(epq), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<String> editEpq(@PathVariable("id") Long id) {
		EmployeeProfessionalQualification epq = epqService.findOne(id);
		if (epq ==null) {
			return new ResponseEntity<String> ("Bad parameters", HttpStatus.BAD_REQUEST);
		}
		epqService.delete(epq);
		return new ResponseEntity<String> ("Success", HttpStatus.OK);
	}
}