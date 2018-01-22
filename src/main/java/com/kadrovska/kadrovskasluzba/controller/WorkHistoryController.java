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
	@PostMapping(consumes="application/json")
	public ResponseEntity<WorkHistoryDTO> saveWorkHistory(@RequestBody WorkHistoryDTO workHistoryDTO) {
		System.out.println(workHistoryDTO);
		WorkHistory wH = wHistoryService.save(wHDTOtoWh.convert(workHistoryDTO));
		System.out.println(wH);
		return new ResponseEntity<>(wHToWhDTO.convert(wH), HttpStatus.OK);
	}
	
	// edit work history
//	@PutMapping(value="{id}")
//	public ResponseEntity<?> editWorkHistory(@RequestBody WorkHistory workHistory, @PathVariable("id") Long id){
//		WorkHistory workHistory2 = wHistoryService.findOne(id);
//		if (workHistory2 == null){
//			return new ResponseEntity<String>("Can't find work history with given id", HttpStatus.BAD_REQUEST);
//		}
//		
//		workHistory2.set
//		
//		nwd2.setNonworkingDayDate(nwd.getNonworkingDayDate());
//		nwd2.setNonworkingDayDescription(nwd.getNonworkingDayDescription());
//		
//		nonworkingDayService.save(nwd2);
//		
//		return new ResponseEntity<NonworkingDay>(nwd2, HttpStatus.OK);
//	}
	
	
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
