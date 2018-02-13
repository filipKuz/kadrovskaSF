package com.kadrovska.kadrovskasluzba.controller;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kadrovska.kadrovskasluzba.converter.AHRDTOtoAHR;
import com.kadrovska.kadrovskasluzba.converter.AHRtoAHRDTO;
import com.kadrovska.kadrovskasluzba.dto.AnnualHolidayRegulationDTO;
import com.kadrovska.kadrovskasluzba.model.AnnualHolidayRegulation;
import com.kadrovska.kadrovskasluzba.model.Employee;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.AnnualHolidayRegulationServiceInterface;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.EmployeeServiceInterface;

@Controller
@RequestMapping("/api/annualHolidayRegulations")
public class AnnualHolidayRegulationController {

	@Autowired
	private AHRtoAHRDTO toAhrDTO;

	@Autowired
	private AHRDTOtoAHR toAHR;

	@Autowired
	private AnnualHolidayRegulationServiceInterface annualHolidayRegulationService;

	@Autowired
	private EmployeeServiceInterface employeeService;
	
	Integer thisYear = Year.now().getValue();

	@GetMapping
	public ResponseEntity<List<AnnualHolidayRegulationDTO>> getAnnualHolidayRegulations() {

		return new ResponseEntity<>(toAhrDTO.convert(annualHolidayRegulationService.findByBusinessYear(thisYear)),
				HttpStatus.OK);
	}

	@GetMapping(value = "/findById/{id}")
	public ResponseEntity<AnnualHolidayRegulationDTO> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<AnnualHolidayRegulationDTO>(
				toAhrDTO.convert(annualHolidayRegulationService.findOne(id)), HttpStatus.OK);
	}

	@GetMapping(value = "/findByEmployee/{employeeId}/{businessYear}")
	public ResponseEntity<List<AnnualHolidayRegulationDTO>> getAHRByEmployeeId(
			@PathVariable("employeeId") Long employeeId, @PathVariable("businessYear") int businessYear) {

		return new ResponseEntity<>(
				(toAhrDTO.convert(
						annualHolidayRegulationService.findByEmployeeEmployeeIdAndBusinessYear(employeeId, businessYear))),
				HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<AnnualHolidayRegulationDTO> saveAnnualHolidayRegulation(
			@RequestBody AnnualHolidayRegulationDTO annualHolidayRegulationDTO) {
		AnnualHolidayRegulation a = annualHolidayRegulationService.save(toAHR.convert(annualHolidayRegulationDTO));
		return new ResponseEntity<>(toAhrDTO.convert(a), HttpStatus.OK);
	}

	@PostMapping(value = "createAnnualHolidayRegulations")
	public ResponseEntity<List<AnnualHolidayRegulationDTO>> createAnnualHolidayRegulations() {

		List<Employee> employees = employeeService.findActiveEmployees();
		List<AnnualHolidayRegulationDTO> annualHolidayRegulationsDTO = new ArrayList<AnnualHolidayRegulationDTO>();
		for (Employee e : employees) {
			if (!e.thisYearAHR()) {
				Integer numOfDays = 0;
				Integer extraVacationDays = 0;
				Integer numOfMinimalDays = 20;
				Integer numOfAdditionalVacationDays = (int) e.getNumOfAdditionalVacationDays();
				if (e.getCurrentWorkPlace() != null) {
					extraVacationDays = (int) e.getCurrentWorkPlace().getExtraVacationDays();
				}

				// System.out.println("Broj slobodnih dana zakosnskog minimuma: " +
				// numOfMinimalDays);
				// System.out.println("Broj dodatnih slobodnih dana zbog staza: " +
				// numOfAdditionalVacationDays);
				// System.out.println("Dodatni slobodni dani zbog ekstremnog radnog mesta: " +
				// extraVacationDays);
				numOfDays += (numOfAdditionalVacationDays + numOfMinimalDays + extraVacationDays);
				// System.out.println("Ukupno slobodnih dana za ovu godinu " + numOfDays);

				AnnualHolidayRegulation a = new AnnualHolidayRegulation();
				a.setBusinessYear(Year.now().getValue());
				a.setEmployee(e);
				a.setNumOfDays(numOfDays);	
				annualHolidayRegulationService.save(a);
				annualHolidayRegulationsDTO.add(toAhrDTO.convert(a));
			}
		}
		return new ResponseEntity<>(annualHolidayRegulationsDTO , HttpStatus.CREATED);
	}
	
}