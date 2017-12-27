package com.kadrovska.kadrovskasluzba.controller;

import java.time.Year;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kadrovska.kadrovskasluzba.converter.AHRDTOtoAHR;
import com.kadrovska.kadrovskasluzba.converter.AHRtoAHRDTO;
import com.kadrovska.kadrovskasluzba.dto.AnnualHolidayRegulationDTO;
import com.kadrovska.kadrovskasluzba.model.AnnualHolidayRegulation;
import com.kadrovska.kadrovskasluzba.model.Employee;
import com.kadrovska.kadrovskasluzba.services.AnnualHolidayRegulationService;
import com.kadrovska.kadrovskasluzba.services.EmployeeService;


@Controller
@RequestMapping("/api/annualHolidayRegulations")
public class AnnualHolidayRegulationController {
	
	@Autowired
	private AHRtoAHRDTO toAhrDTO;
	
	@Autowired
	private AHRDTOtoAHR toAHR;

	@Autowired
	private AnnualHolidayRegulationService annualHolidayRegulationService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<List<AnnualHolidayRegulationDTO>> getAnnualHolidayRegulations() {

		return new ResponseEntity<>(toAhrDTO.convert(annualHolidayRegulationService.findAll()), HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<AnnualHolidayRegulationDTO> saveAnnualHolidayRegulation(@RequestBody AnnualHolidayRegulationDTO annualHolidayRegulationDTO) {
		System.out.println(annualHolidayRegulationDTO);
		AnnualHolidayRegulation a = annualHolidayRegulationService.save(toAHR.convert(annualHolidayRegulationDTO));
		System.out.println(a);
		return new ResponseEntity<>(toAhrDTO.convert(a), HttpStatus.OK);
	}
	
	@PostMapping(value="createAnnualHolidayRegulations")
	public ResponseEntity<List<AnnualHolidayRegulation>> createAnnualHolidayRegulations(){
		List<Employee> employees = employeeService.findAll();
		
		for (Employee e: employees){
			Integer numOfDays = 0;
			Integer numOfMinimalDays = 20;
			Integer numOfAdditionalVacationDays = (int) e.getNumOfAdditionalVacationDays();
			Integer extraVacationDays = (int) e.getCurrentWorkPlace().getExtraVacationDays();
			System.out.println("Broj slobodnih dana zakosnskog minimuma: " + numOfMinimalDays);
			System.out.println("Broj dodatnih slobodnih dana zbog staza: "+ numOfAdditionalVacationDays);
			System.out.println("Dodatni slobodni dani zbog exstremnog radnog mesta radnog mesta: " + extraVacationDays );
			numOfDays += (numOfAdditionalVacationDays + numOfMinimalDays + extraVacationDays);
			System.out.println("Ukupno slobodnih dana za ovu godinu " + numOfDays );
			
			AnnualHolidayRegulation a = new AnnualHolidayRegulation();
			a.setBusinessYear(Year.now().getValue());
			a.setEmployee(e);
			a.setNumOfDays(numOfDays);
			annualHolidayRegulationService.save(a);	
		}
		return null;
		
	}
	
	
	
}
