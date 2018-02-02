package com.kadrovska.kadrovskasluzba.controller;

import java.sql.Date;
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

import com.kadrovska.kadrovskasluzba.converter.WorkHistoryDTOtoWorkHistory;
import com.kadrovska.kadrovskasluzba.converter.WorkHistoryToWorkHistoryDTO;
import com.kadrovska.kadrovskasluzba.dto.WorkHistoryDTO;
import com.kadrovska.kadrovskasluzba.model.WorkHistory;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.WorkHistoryServiceInterface;

@Controller
@RequestMapping("/api/workHistory")
public class WorkHistoryController {
	
	@Autowired
	private WorkHistoryToWorkHistoryDTO wHToWhDTO; 
	
	@Autowired
	private WorkHistoryDTOtoWorkHistory wHDTOtoWh;
	
	@Autowired
	private WorkHistoryServiceInterface wHistoryService;
	
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

	// new work history
	@PostMapping(consumes = "application/json")
	public ResponseEntity<WorkHistory> saveWorkHistory(@RequestBody WorkHistoryDTO newWorkHistory ) {

		WorkHistory wh = wHDTOtoWh.convert(newWorkHistory);
		
		WorkHistory workHistory = wHistoryService.save(wh);
		
		List<WorkHistory> allWh= wHistoryService.findAll();
		
		if(allWh.size() > 0) {
			WorkHistory lastWorkHistory = allWh.get(0);
			lastWorkHistory.setEndDate(new Date(System.currentTimeMillis()));
			wHistoryService.save(lastWorkHistory);
		}
		
		
		
		
		return new ResponseEntity("success", HttpStatus.CREATED);
	}
	
		
	// edit work history
	@PutMapping(value="{id}")
	public ResponseEntity<?> editWorkHistory(@RequestBody WorkHistoryDTO workHistory, @PathVariable("id") Long id){
		System.out.println("----------------------------------------------------------");
		System.out.println("usoo");
		System.out.println("----------------------------------------------------------");
		try{
			WorkHistory workHistory2 = wHistoryService.findOne(id);
			if (workHistory2 == null){
				return new ResponseEntity<String>("Can't find work history given id", HttpStatus.BAD_REQUEST);
			}
				workHistory2.setCompanyName(workHistory.getPreviousCompany());
				workHistory2.setStartDate(workHistory.getStartDate());
				workHistory2.setEndDate(workHistory.getEndDate());
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
}