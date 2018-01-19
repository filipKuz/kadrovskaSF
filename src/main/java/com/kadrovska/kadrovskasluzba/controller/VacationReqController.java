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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kadrovska.kadrovskasluzba.converter.VacationReqDTOToVacationReq;
import com.kadrovska.kadrovskasluzba.converter.VacationReqToVacationReqDTO;
import com.kadrovska.kadrovskasluzba.dto.VacationRequestDTO;
import com.kadrovska.kadrovskasluzba.model.AnnualHolidayRegulation;
import com.kadrovska.kadrovskasluzba.model.VacationRequest;
import com.kadrovska.kadrovskasluzba.services.AnnualHolidayRegulationService;
import com.kadrovska.kadrovskasluzba.services.NonworkingDayServive;
import com.kadrovska.kadrovskasluzba.services.VacationRequestService;

@Controller
@RequestMapping("/api/vacationReq")
public class VacationReqController {

	@Autowired
	VacationRequestService vacationReqService;

	@Autowired
	NonworkingDayServive nwdService;

	@Autowired
	AnnualHolidayRegulationService ahrService;

	@Autowired
	VacationReqToVacationReqDTO toVReqDTO;

	@Autowired
	VacationReqDTOToVacationReq toVReq;

	@GetMapping(value = "/findByAHRId/{ahrId}")
	public ResponseEntity<List<VacationRequestDTO>> getVReqbyAHRDD(@PathVariable("ahrId") Long ahrId) {

		return new ResponseEntity<>(
				(toVReqDTO.convert(vacationReqService.findByAnnualHolidayRegulationAnnualHolidayRegulationId(ahrId))),
				HttpStatus.OK);
	}

	@GetMapping(value = "/findById/{id}")
	public ResponseEntity<VacationRequestDTO> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<VacationRequestDTO>(toVReqDTO.convert(vacationReqService.findOne(id)), HttpStatus.OK);
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<String> deleteVReq(@PathVariable("id") Long id) {
		VacationRequest vreq = vacationReqService.findOne(id);
		if (vreq == null) {
			return new ResponseEntity<String>("Bad parameters", HttpStatus.BAD_REQUEST);
		}

		AnnualHolidayRegulation ahr = ahrService
				.findOne(vreq.getAnnualHolidayRegulation().getAnnualHolidayRegulationId());
		ahr.setNumOfDays(ahr.getNumOfDays() + vreq.getNumOfDays());
		vacationReqService.delete(id);
		ahrService.save(ahr);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<?> createVReq(@RequestBody VacationRequestDTO vReqDTO) {

		AnnualHolidayRegulation ahr = ahrService.findOne(vReqDTO.getAnnualHolidayRegulationId());
		if (ahr == null) {
			return new ResponseEntity<String>("Bad parameters", HttpStatus.BAD_REQUEST);
		}

		VacationRequest vReq = new VacationRequest();
		vReq.setAnnualHolidayRegulation(ahr);
		vReq.setNumOfDays(vReqDTO.getNumOfDays());
		vReq.setStrDate(vReqDTO.getStartDate());
		vReq.setEndDate(vacationReqService.generateEndDate(vReqDTO.getStartDate(), vReqDTO.getNumOfDays()));
		ahr.setNumOfDays(ahr.getNumOfDays() - vReq.getNumOfDays());
		if (ahr.getNumOfDays() >= 0) {
			ahrService.save(ahr);
			vacationReqService.save(vReq);
			return new ResponseEntity<VacationRequestDTO>(toVReqDTO.convert(vReq), HttpStatus.OK);
		}

		return new ResponseEntity<String>("Bad parameters", HttpStatus.NOT_ACCEPTABLE);
	}

}
