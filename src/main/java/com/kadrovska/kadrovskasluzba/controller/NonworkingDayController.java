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

import com.kadrovska.kadrovskasluzba.model.NonworkingDay;
import com.kadrovska.kadrovskasluzba.services.NonworkingDayServive;

@Controller
@RequestMapping("api/nonworkingDays")
public class NonworkingDayController {
	
	@Autowired
	NonworkingDayServive nonworkingDayService;

	@GetMapping
	public ResponseEntity<List<NonworkingDay>> getNonworkingDays() {
		return new ResponseEntity<>(nonworkingDayService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="{id}")
	public ResponseEntity<NonworkingDay> getNonworkingDayById(@PathVariable("id") Long id) {
		return new ResponseEntity<NonworkingDay>(nonworkingDayService.findOne(id), HttpStatus.OK);
	}
	
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<NonworkingDay> saveNonworkingDay(@RequestBody NonworkingDay newNonworkingDay) {
		NonworkingDay nonworkingDay = nonworkingDayService.save(newNonworkingDay);
		return new ResponseEntity<>(nonworkingDay, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<String> deleteNonworkingDay(@PathVariable("id") Long id ){
		NonworkingDay nwd = nonworkingDayService.findOne(id);
		if (nwd == null) {
			return new ResponseEntity<String> ("Bad parameters", HttpStatus.BAD_REQUEST);
		}
		nonworkingDayService.delete(nwd);
		return 	new ResponseEntity<String> ("Success", HttpStatus.OK);
	
	}
	
	@PutMapping(value="{id}")
	public ResponseEntity<?> editNonworkingDay(@RequestBody NonworkingDay nwd , @PathVariable("id") Long id){
		NonworkingDay nwd2 = nonworkingDayService.findOne(id);
		if (nwd2 == null){
			return new ResponseEntity<String>("Can't find non-working day with given id", HttpStatus.BAD_REQUEST);
		}
		
		nwd2.setNonworkingDayDate(nwd.getNonworkingDayDate());
		nwd2.setNonworkingDayDescription(nwd.getNonworkingDayDescription());
		
		nonworkingDayService.save(nwd2);
		
		return new ResponseEntity<NonworkingDay>(nwd2, HttpStatus.OK);
	}
}
