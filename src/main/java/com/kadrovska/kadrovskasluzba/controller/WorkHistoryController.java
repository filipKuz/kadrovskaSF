package com.kadrovska.kadrovskasluzba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping
	public ResponseEntity<List<WorkHistoryDTO>> getWorkHistory() {

		return new ResponseEntity<>(wHToWhDTO.convert(wHistoryService.findAll()), HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<WorkHistoryDTO> saveWorkHistory(@RequestBody WorkHistoryDTO workHistoryDTO) {
		System.out.println(workHistoryDTO);
		WorkHistory wH = wHistoryService.save(wHDTOtoWh.convert(workHistoryDTO));
		System.out.println(wH);
		return new ResponseEntity<>(wHToWhDTO.convert(wH), HttpStatus.OK);
	}

}
