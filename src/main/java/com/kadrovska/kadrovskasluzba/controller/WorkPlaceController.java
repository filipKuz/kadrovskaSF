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

import com.kadrovska.kadrovskasluzba.converter.WorkPlaceDTOtoWorkPlace;
import com.kadrovska.kadrovskasluzba.converter.WorkPlaceToWorkPlaceDTO;
import com.kadrovska.kadrovskasluzba.dto.WorkHistoryDTO;
import com.kadrovska.kadrovskasluzba.dto.WorkPlaceDTO;
import com.kadrovska.kadrovskasluzba.model.WorkHistory;
import com.kadrovska.kadrovskasluzba.model.WorkPlace;
import com.kadrovska.kadrovskasluzba.services.WorkHistoryService;
import com.kadrovska.kadrovskasluzba.services.WorkPlaceService;

@Controller
@RequestMapping("/api/workPlace")
public class WorkPlaceController {

	
	@Autowired
	private WorkPlaceToWorkPlaceDTO workPlaceToWorkPlaceDTO;
	
	
	@Autowired
	private WorkPlaceDTOtoWorkPlace workPlaceDTOtoWorkPlace;
	
	@Autowired
	private WorkPlaceService wPlaceService;
	
	@GetMapping
	public ResponseEntity<List<WorkPlaceDTO>> getWorkPlaces() {

		return new ResponseEntity<>(workPlaceToWorkPlaceDTO.convert(wPlaceService.findAll()), HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<WorkPlaceDTO> saveWorkPlace(@RequestBody WorkPlaceDTO workPlaceDTO) {
		System.out.println(workPlaceDTO);
		WorkPlace wP = wPlaceService.save(workPlaceDTOtoWorkPlace.convert(workPlaceDTO));
		System.out.println(wP);
		return new ResponseEntity<>(workPlaceToWorkPlaceDTO.convert(wP), HttpStatus.OK);
	}
	
	
}
