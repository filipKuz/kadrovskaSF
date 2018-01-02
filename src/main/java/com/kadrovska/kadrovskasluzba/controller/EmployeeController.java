package com.kadrovska.kadrovskasluzba.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kadrovska.kadrovskasluzba.converter.EmployeeDTOtoEmployee;
import com.kadrovska.kadrovskasluzba.converter.EmployeeToEmployeeDTO;
import com.kadrovska.kadrovskasluzba.converter.WorkHistoryDTOtoWorkHistory;
import com.kadrovska.kadrovskasluzba.dto.EmployeeDTO;
import com.kadrovska.kadrovskasluzba.dto.WorkHistoryDTO;
import com.kadrovska.kadrovskasluzba.model.Company;
import com.kadrovska.kadrovskasluzba.model.Employee;
import com.kadrovska.kadrovskasluzba.model.WorkHistory;
import com.kadrovska.kadrovskasluzba.model.WorkPlace;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.CityServiceInterface;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.CompanyServiceInterface;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.EmployeeServiceInterface;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.WorkHistoryServiceInterface;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.WorkPlaceServiceInterface;

@Controller
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeServiceInterface employeeService;

	@Autowired
	private EmployeeToEmployeeDTO toEmployeeDTO;

	@Autowired
	private EmployeeDTOtoEmployee toEmployee;

	@Autowired
	private WorkHistoryDTOtoWorkHistory toWh;
	
	@Autowired
	EmployeeServiceInterface employeeServiceInterface;
	
	@Autowired
	CityServiceInterface cityServiceInterface;
	
	@Autowired 
	WorkHistoryServiceInterface workHistoryServiceInterface;
	
	@Autowired
	WorkPlaceServiceInterface workPlaceServiceInterface;
	
	@Autowired
	CompanyServiceInterface companyServiceInterface;
	
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getEmployees() {
		return new ResponseEntity<>(toEmployeeDTO.convert(employeeService.findAll()), HttpStatus.OK);
	}
	
	@GetMapping(value="activeEmployees")
	public ResponseEntity<List<EmployeeDTO>> getActiveEmployees(@RequestParam("page") int page,
																@RequestParam("size") int size) {

		Page<Employee> employees = employeeService.findActiveEmployees(new PageRequest(page, size));
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(employees.getTotalPages()));
		headers.add("access-control-expose-headers", "totalPages");
		return new ResponseEntity<>(toEmployeeDTO.convert(employees.getContent()), headers, HttpStatus.OK);
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long id) {
		return new ResponseEntity<EmployeeDTO>(toEmployeeDTO.convert(employeeServiceInterface.findOne(id)), HttpStatus.OK);
	}
	

	@PostMapping(consumes = "application/json")
	public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody Map<String, Object> data) {
		Company com = companyServiceInterface.findByIsOursTrue();
		ObjectMapper mapper = new ObjectMapper();
		
		EmployeeDTO ed = mapper.convertValue(data.get("Employee"), EmployeeDTO.class);
		ed.setCompanyId(com.getId());
		WorkPlace wp = workPlaceServiceInterface.findOne(Long.valueOf(data.get("workPlaceId").toString()));
		WorkHistoryDTO whDTO = new WorkHistoryDTO();
		System.out.println("1");
		Employee employee = employeeService.save(toEmployee.convert(ed));
		
		whDTO.setEmployeeId(employee.getEmployeeId());
		Calendar calendar = Calendar.getInstance();
		Date currentDate = calendar.getTime();
		whDTO.setStartDate(new java.sql.Date(currentDate.getTime()));
		whDTO.setPreviousCompany(com.getName());
		System.out.println("2");
		//whDTO.setEndDate(new java.sql.Date(currentDate.getTime()));
		whDTO.setWorkPlaceId(wp.getWorkPlaceId());
		System.out.println(whDTO);
		System.out.println(wp);
		System.out.println("3");
		WorkHistory wh1 = workHistoryServiceInterface.save(toWh.convert(whDTO));
		System.out.println(wh1);
		return new ResponseEntity<>(toEmployeeDTO.convert(employee), HttpStatus.OK);
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
		e.setCity(cityServiceInterface.findOne(dto.getCityId()));
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
	
	@PutMapping(value="delete/{id}") 
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
		Employee e = employeeServiceInterface.findOne(id);
		if (e == null) {
			return new ResponseEntity<String>("Can't find employee with given id", HttpStatus.BAD_REQUEST);
		}
		
		Calendar calendar = Calendar.getInstance();
		Date currentDate = calendar.getTime();
		java.sql.Date date = new java.sql.Date(currentDate.getTime());
		WorkHistory wh = workHistoryServiceInterface.findByEmployeeEmployeeIdAndEndDateIsNull(id);
		if(wh != null) {
			wh.setEndDate(date);
		}
		
		employeeServiceInterface.save(e);
		
		return new ResponseEntity<EmployeeDTO>(toEmployeeDTO.convert(e), HttpStatus.OK);
	};
	
	
}

