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
	
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<NonworkingDay> saveNonworkingDay(@RequestBody NonworkingDay nonworkingDay) {
		NonworkingDay nonworkingDay2 = nonworkingDayService.save(nonworkingDay);
		return new ResponseEntity<>(nonworkingDay2, HttpStatus.OK);
	}
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<?> deleteNonworkingDay(@PathVariable("id") Long id ){
		nonworkingDayService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@PutMapping(value="{id}")
	public ResponseEntity<?> editNonworkingDay(@RequestBody NonworkingDay nwd , @PathVariable("id") Long id){
		NonworkingDay nwd2 = nonworkingDayService.findOne(id);
		if (nwd2 == null){
			return new ResponseEntity<String>("Can't find non-working day with given id", HttpStatus.BAD_REQUEST);
		}
		
		nwd2.setDate(nwd.getDate());
		nwd2.setDescription(nwd.getDescription());
		
		nonworkingDayService.save(nwd2);
		
		return new ResponseEntity<NonworkingDay>(nwd2, HttpStatus.OK);
	}
}
