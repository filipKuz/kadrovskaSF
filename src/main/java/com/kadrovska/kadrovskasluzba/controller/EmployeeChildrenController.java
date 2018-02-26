package com.kadrovska.kadrovskasluzba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kadrovska.kadrovskasluzba.converter.EmployeeChildDTOToEmployeeChild;
import com.kadrovska.kadrovskasluzba.converter.EmployeeChildToEmployeeChildDTO;
import com.kadrovska.kadrovskasluzba.dto.EmployeeChildDTO;
import com.kadrovska.kadrovskasluzba.model.EmployeeChild;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.EmployeeChildServiceInterface;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.EmployeeServiceInterface;

@Controller
@RequestMapping("api/children")
public class EmployeeChildrenController {

	@Autowired
	EmployeeChildServiceInterface childrenService;

	@Autowired
	EmployeeServiceInterface employeeService;

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

	@PostMapping(consumes = "application/json")
	public ResponseEntity<?> saveChild(@Validated @RequestBody EmployeeChildDTO childDTO, Errors errors) {
		if (errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
		}

		EmployeeChild child = childrenService.save(childDTOToChildConverter.convert(childDTO));

		return new ResponseEntity<>(childToChildDTOConverter.convert(child), HttpStatus.OK);
	}

	@PutMapping(value = "{id}")
	public ResponseEntity<?> editChild(@Validated @RequestBody EmployeeChildDTO childDTO, @PathVariable("id") Long id,
			Errors errors) {
		if (errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
		}

		EmployeeChild child = childrenService.findOne(id);
		if (child == null) {
			return new ResponseEntity<String>("Can't find child with given id", HttpStatus.BAD_REQUEST);
		}

		child.setName(childDTO.getName());
		child.setLastName(childDTO.getLastName());
		child.setSex(childDTO.getSex());
		child.setBirthDate(childDTO.getBirthDate());
		child.setParent(employeeService.findOne(childDTO.getParentId()));

		childrenService.save(child);

		return new ResponseEntity<EmployeeChildDTO>(childToChildDTOConverter.convert(child), HttpStatus.OK);
	};

	@DeleteMapping(value = "{id}")
	public ResponseEntity<String> deleteChild(@PathVariable("id") Long id) {
		EmployeeChild child = childrenService.findOne(id);
		if (child == null) {
			return new ResponseEntity<String>("Can't find child with given id", HttpStatus.BAD_REQUEST);
		}
		childrenService.delete(id);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
}