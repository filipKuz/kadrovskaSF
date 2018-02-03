package com.kadrovska.kadrovskasluzba.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.LocalDateTimeParser;
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

import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;
import com.kadrovska.kadrovskasluzba.converter.WorkHistoryDTOtoWorkHistory;
import com.kadrovska.kadrovskasluzba.converter.WorkHistoryToWorkHistoryDTO;
import com.kadrovska.kadrovskasluzba.dto.VacationRequestDTO;
import com.kadrovska.kadrovskasluzba.dto.WorkHistoryDTO;
import com.kadrovska.kadrovskasluzba.model.AnnualHolidayRegulation;
import com.kadrovska.kadrovskasluzba.model.Employee;
import com.kadrovska.kadrovskasluzba.model.VacationRequest;
import com.kadrovska.kadrovskasluzba.model.WorkHistory;
import com.kadrovska.kadrovskasluzba.model.WorkPlace;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.EmployeeServiceInterface;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.WorkHistoryServiceInterface;
import com.kadrovska.kadrovskasluzba.services.WorkPlaceService;

@Controller
@RequestMapping("/api/workHistory")
public class WorkHistoryController {
	
	@Autowired
	private WorkHistoryToWorkHistoryDTO wHToWhDTO; 
	
	@Autowired
	private WorkHistoryDTOtoWorkHistory wHDTOtoWh;
	
	@Autowired
	private WorkHistoryServiceInterface wHistoryService;
	
	@Autowired
	private EmployeeServiceInterface employeeService;
	
	@Autowired
	private WorkPlaceService workPlaceService;
	
	// get work history
	@GetMapping
	public ResponseEntity<List<WorkHistoryDTO>> getWorkHistory() {

		return new ResponseEntity<>(wHToWhDTO.convert(wHistoryService.findAll()), HttpStatus.OK);
	}
	
	
	// save work history
//	@PostMapping(consumes="application/json")
//	public ResponseEntity<WorkHistoryDTO> saveWorkHistory(@RequestBody WorkHistoryDTO workHistoryDTO) {
//		System.out.println(workHistoryDTO);
//		WorkHistory wH = wHistoryService.save(wHDTOtoWh.convert(workHistoryDTO));
//		System.out.println(wH);
//		return new ResponseEntity<>(wHToWhDTO.convert(wH), HttpStatus.OK);
//	}
	
	@GetMapping(value = "findByEmployeeId/{employeeId}")
	public ResponseEntity<List<WorkHistoryDTO>> getWorkHistoryByEmployeeId(
			@PathVariable("employeeId") Long employeeId) {

		return new ResponseEntity<>((wHToWhDTO.convert(wHistoryService.findByEmployeeId(employeeId))),
				HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<WorkHistoryDTO> getCity(@PathVariable long id) {
		return new ResponseEntity<>(wHToWhDTO.convert(wHistoryService.findOne(id)), HttpStatus.OK);
	}

	
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<?> createVReq(@Validated @RequestBody WorkHistoryDTO workHistoryDTO, Errors errors) {
		
		if(errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
			}
		
		WorkHistory workHistory = new WorkHistory();
		
		workHistory.setWorkHistoryId(workHistoryDTO.getWorkHistoryId());
		workHistory.setCompanyName(workHistoryDTO.getPreviousCompany());
		workHistory.setStartDate(workHistoryDTO.getStartDate());
		workHistory.setEndDate(workHistoryDTO.getEndDate());
		
		Employee employee = employeeService.findOne(workHistoryDTO.getEmployeeId());
		if (employee != null) {
			workHistory.setEmployee(employee);
		}
		
		if(workHistoryDTO.getWorkPlaceId() != null) {
			WorkPlace workPlace = workPlaceService.findOne(workHistoryDTO.getWorkPlaceId());
			if (workPlace != null) {
				workHistory.setWorkPlace(workPlace);
			}
		}
		
		
		
		Calendar calendar = Calendar.getInstance();
		Date currentDate = calendar.getTime();
		java.sql.Date date = new java.sql.Date(currentDate.getTime());
		
		//wHistoryService.save(workHistory);
		
		List<WorkHistory> allWh= wHistoryService.findAll();
		
		WorkHistory lastWorkHistory = wHistoryService.findByEmployeeEmployeeIdAndEndDateIsNull(workHistory.getEmployee().getEmployeeId());
		if (lastWorkHistory != null) {
			lastWorkHistory.setEndDate(date);
		}
		
	
		wHistoryService.save(lastWorkHistory);
		wHistoryService.save(workHistory);
		
		return new ResponseEntity<WorkHistoryDTO>(wHToWhDTO.convert(workHistory), HttpStatus.OK);
		
	}

	
		
	// edit work history
	@PutMapping(value="{id}")
	public ResponseEntity<?> editWorkHistory(@Validated @RequestBody WorkHistoryDTO workHistoryDTO, @PathVariable("id") Long id, Errors errors){
		if(errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
			}
		System.out.println("----------------------------------------------------------");
		System.out.println("usoo");
		System.out.println("----------------------------------------------------------");
		try{
			WorkHistory workHistory2 = wHistoryService.findOne(id);
			if (workHistory2 == null){
				return new ResponseEntity<String>("Can't find work history given id", HttpStatus.BAD_REQUEST);
			}
				workHistory2.setCompanyName(workHistoryDTO.getPreviousCompany());
				workHistory2.setStartDate(workHistoryDTO.getStartDate());
				workHistory2.setEndDate(workHistoryDTO.getEndDate());
				
				if(workHistory2.getWorkPlace().getWorkPlaceId() != null) {
					WorkPlace workPlace = workPlaceService.findOne(workHistoryDTO.getWorkPlaceId());
					System.out.println("----------------------------------------------------------");
					System.out.println("usoo2");
					System.out.println("----------------------------------------------------------");
					if (workPlace != null) {
						workHistory2.setWorkPlace(workPlace);
						System.out.println("----------------------------------------------------------");
						System.out.println("usoo3");
						System.out.println("----------------------------------------------------------");
					}
				}
				
				wHistoryService.save(workHistory2);
				
				return new ResponseEntity("success", HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<String>("somethgin", HttpStatus.OK);
			}
		}
	
	// delete work history
	@DeleteMapping(value="{id}")
	public ResponseEntity<String> deleteWOrkHistory(@PathVariable("id") Long id ){
		WorkHistory workHistory = wHistoryService.findOne(id);
		if (workHistory == null) {
			return new ResponseEntity<String> ("Can't find work history with given id", HttpStatus.BAD_REQUEST);
		}
		wHistoryService.delete(workHistory);
		return 	new ResponseEntity<String> ("Success", HttpStatus.OK);
	
	}
	

//	// new work history
//	@PostMapping(consumes = "application/json")
//	public ResponseEntity<?> saveWorkHistory(@Validated @RequestBody WorkHistoryDTO newWorkHistory, Errors errors ) {
//		if(errors.hasErrors()) {
//			return new ResponseEntity<String>(errors.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
//			}
//
//		WorkHistory wh = wHDTOtoWh.convert(newWorkHistory);
//		
//		WorkHistory workHistory = wHistoryService.save(wh);
//		
//		List<WorkHistory> allWh= wHistoryService.findAll();
//		
//		if(allWh.size() > 0) {
//			WorkHistory lastWorkHistory = allWh.get(0);
//			lastWorkHistory.setEndDate(new Date(System.currentTimeMillis()));
//			wHistoryService.save(lastWorkHistory);
//		}
//		
//		return new ResponseEntity("success", HttpStatus.CREATED);
//	}
	
	//		if(allWh.size() > 0) {
//	WorkHistory lastWorkHistory = wHistoryService.findByEmployeeEmployeeIdAndEndDateIsNull(workHistory.getEmployee().getEmployeeId());
//	if (lastWorkHistory != null) {
//		lastWorkHistory.setEndDate(date);
//		wHistoryService.save(lastWorkHistory);
//	}
//	
//	//wHistoryService.save(lastWorkHistory);
}