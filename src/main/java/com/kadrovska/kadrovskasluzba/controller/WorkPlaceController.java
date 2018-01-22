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

import com.kadrovska.kadrovskasluzba.converter.WorkPlaceDTOtoWorkPlace;
import com.kadrovska.kadrovskasluzba.converter.WorkPlaceToWorkPlaceDTO;
import com.kadrovska.kadrovskasluzba.dto.CityDTO;
import com.kadrovska.kadrovskasluzba.dto.WorkPlaceDTO;
import com.kadrovska.kadrovskasluzba.model.NonworkingDay;
import com.kadrovska.kadrovskasluzba.model.WorkHistory;
import com.kadrovska.kadrovskasluzba.model.WorkPlace;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.WorkPlaceServiceInterface;
import com.kadrovska.kadrovskasluzba.services.WorkHistoryService;



@Controller
@RequestMapping("/api/workPlace")
public class WorkPlaceController {

	@Autowired
	private WorkPlaceToWorkPlaceDTO workPlaceToWorkPlaceDTO;

	@Autowired
	private WorkPlaceDTOtoWorkPlace workPlaceDTOtoWorkPlace;

	@Autowired
	private WorkPlaceServiceInterface workPlaceService;


	@Autowired
	private WorkHistoryService workHistoryService;
	
	// get work place
	@GetMapping
	public ResponseEntity<List<WorkPlaceDTO>> getWorkPlaces() {

		return new ResponseEntity<>(workPlaceToWorkPlaceDTO.convert(workPlaceService.findAll()), HttpStatus.OK);
	}
	
	
	// get work place by Id
	@GetMapping(value = "/{id}")
	public ResponseEntity<WorkPlaceDTO> getWorkPlaceById(@PathVariable long id) {
		return new ResponseEntity<>(workPlaceToWorkPlaceDTO.convert(workPlaceService.findOne(id)), HttpStatus.OK);
	}
	
	// save work place
//	@PostMapping(consumes = "application/json")
//	public ResponseEntity<WorkPlaceDTO> saveWorkPlace(@RequestBody WorkPlaceDTO workPlaceDTO) {
//		System.out.println(workPlaceDTO);
//		WorkPlace workPlace = workPlaceService.save(workPlaceDTOtoWorkPlace.convert(workPlaceDTO));
//		System.out.println(workPlace);
//		return new ResponseEntity<>(workPlaceToWorkPlaceDTO.convert(workPlace), HttpStatus.OK);
//	}
//	
	// new work place
	@PostMapping(consumes = "application/json")
	public ResponseEntity<WorkPlace> saveWorkPlace(@RequestBody WorkPlace newWorkPlace) {
		System.out.println(newWorkPlace.toString());
		WorkPlace workPlace = workPlaceService.save(newWorkPlace);
		return new ResponseEntity<>(workPlace, HttpStatus.CREATED);
	}
	
	// edit work place
	@PutMapping(value="{id}")
	public ResponseEntity<?> editWorkPlace(@RequestBody WorkPlace workPlace , @PathVariable("id") Long id){
		WorkPlace workPlace2 = workPlaceService.findOne(id);
		if (workPlace2 == null){
			return new ResponseEntity<String>("Can't find work place given id", HttpStatus.BAD_REQUEST);
		}
		
		workPlace2.setName(workPlace.getName());
		workPlace2.setCoefficient(workPlace.getCoefficient());
		workPlaceService.save(workPlace2);
		
		return new ResponseEntity<WorkPlace>(workPlace2, HttpStatus.OK);
	}
	
	
	
	// delete work place
	@DeleteMapping(value="{id}")
	public ResponseEntity<String> deleteWorkPLace(@PathVariable("id") Long id ){
		WorkPlace workPlace = workPlaceService.findOne(id);
		if (workPlace == null) {
			return new ResponseEntity<String> ("Can't find work place with given id", HttpStatus.BAD_REQUEST);
		}
		if(workPlace.getWorkHistory() != null && workPlace.getWorkHistory().size() > 0) {
			for(WorkHistory wh : workPlace.getWorkHistory()){
				workHistoryService.delete(wh.getWorkHistoryId());
			}
		}
		
		workPlaceService.delete(workPlace);
		return 	new ResponseEntity<String> ("Success", HttpStatus.OK);
		
	}
}