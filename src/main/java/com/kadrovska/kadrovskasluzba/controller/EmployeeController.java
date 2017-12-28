package com.kadrovska.kadrovskasluzba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping(value="{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long id) {
		
		return new ResponseEntity<EmployeeDTO>(toEmployeeDTO.convert(employeeServiceInterface.findOne(id)), HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
		System.out.println(employeeDTO);
		Employee e = employeeServiceInterface.save(toEmployee.convert(employeeDTO));
		System.out.println(e);
		return new ResponseEntity<>(toEmployeeDTO.convert(e), HttpStatus.OK);
	}
	
	
	@PutMapping(value="{id}") 
	public ResponseEntity<?> editEmployee(@RequestBody EmployeeDTO dto, @PathVariable("id") Long id) {
		Employee e = employeeServiceInterface.findOne(id);
		System.out.println(dto);
		if (e == null) {
			return new ResponseEntity<String>("Can't find employee with given id", HttpStatus.BAD_REQUEST);
		}
		
		e.setAddress(dto.getAddress());
		e.setBirthDate(dto.getBirthDate());
		// fali city kontroler e.setCity(dto.getCityId());
		// fali company kontroler e.setCompany(company);
		e.setEmail(dto.getEmail());
		e.setFirstName(dto.getFirstName());
		e.setLastName(dto.getLastName());
		e.setMadenName(dto.getMadenName());
		e.setParentName(dto.getParentName());
		e.setPhoneNumber(dto.getPhoneNumber());
		e.setSex(dto.getSex());
		
		employeeServiceInterface.save(e);
		
		return new ResponseEntity<EmployeeDTO>(toEmployeeDTO.convert(e), HttpStatus.OK);
	};
	
	
	
	
}
