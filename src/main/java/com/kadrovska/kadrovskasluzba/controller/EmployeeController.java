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

import com.kadrovska.kadrovskasluzba.converter.EmployeeDTOtoEmployee;
import com.kadrovska.kadrovskasluzba.converter.EmployeeToEmployeeDTO;
import com.kadrovska.kadrovskasluzba.dto.EmployeeDTO;
import com.kadrovska.kadrovskasluzba.model.Employee;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.EmployeeServiceInterface;

@Controller
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeServiceInterface employeeServiceInterface;

	@Autowired
	private EmployeeToEmployeeDTO toEmployeeDTO;

	@Autowired
	private EmployeeDTOtoEmployee toEmployee;
	
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getEmployees() {

		return new ResponseEntity<>(toEmployeeDTO.convert(employeeServiceInterface.findAll()), HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
		System.out.println(employeeDTO);
		Employee e = employeeServiceInterface.save(toEmployee.convert(employeeDTO));
		System.out.println(e);
		return new ResponseEntity<>(toEmployeeDTO.convert(e), HttpStatus.OK);
	}
	
	
}
