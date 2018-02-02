package com.kadrovska.kadrovskasluzba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kadrovska.kadrovskasluzba.converter.EmployeeChildDTOToEmployeeChild;
import com.kadrovska.kadrovskasluzba.converter.EmployeeChildToEmployeeChildDTO;
import com.kadrovska.kadrovskasluzba.dto.EmployeeChildDTO;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.EmployeeChildServiceInterface;

@Controller
@RequestMapping("api/children")
public class EmployeeChildrenController {

	@Autowired
	EmployeeChildServiceInterface childrenService;

	@Autowired
	EmployeeChildDTOToEmployeeChild childDTOToChildConverter;

	@Autowired
	EmployeeChildToEmployeeChildDTO childToChildDTOConverter;

	@GetMapping(path = "/all")
	public ResponseEntity<List<EmployeeChildDTO>> getChildren() {
		return new ResponseEntity<>(childToChildDTOConverter.convert(childrenService.findAll()), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<EmployeeChildDTO> getChild(@PathVariable long id) {
		return new ResponseEntity<>(childToChildDTOConverter.convert(childrenService.findOne(id)), HttpStatus.OK);
	}

	@GetMapping(value = "byEmployee/{employeeId}")
	public ResponseEntity<List<EmployeeChildDTO>> getChildrenByEmployee(@PathVariable("employeeId") long employeeId) {
		return new ResponseEntity<>(childToChildDTOConverter.convert(childrenService.findByEmployeeId(employeeId)),
				HttpStatus.OK);
	}
	
	

}
