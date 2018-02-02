package com.kadrovska.kadrovskasluzba.controller;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import com.kadrovska.kadrovskasluzba.converter.AHRDTOtoAHR;
import com.kadrovska.kadrovskasluzba.converter.AHRtoAHRDTO;
import com.kadrovska.kadrovskasluzba.dto.AnnualHolidayRegulationDTO;
import com.kadrovska.kadrovskasluzba.model.AnnualHolidayRegulation;
import com.kadrovska.kadrovskasluzba.model.Employee;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.AnnualHolidayRegulationServiceInterface;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.EmployeeServiceInterface;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

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
	
	/*
	@Autowired 
	@Qualifier("AHRReport1")
	private JasperReportsPdfView ahrReport;
	*/
	
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

	@GetMapping(value = "/findByEmployee/{employeeId}")
	public ResponseEntity<List<AnnualHolidayRegulationDTO>> getAHRByEmployeeId(
			@PathVariable("employeeId") Long employeeId) {

		return new ResponseEntity<>(
				(toAhrDTO.convert(
						annualHolidayRegulationService.findByEmployeeEmployeeIdAndBusinessYear(employeeId, thisYear))),
				HttpStatus.OK);
	}
	
	/*
	@Bean
	@Qualifier("AHRReport1")
	public JasperReportsPdfView getHelloWorldReport() {
	  JasperReportsPdfView v = new JasperReportsPdfView();
	  v.setUrl("classpath:reports/Blank_A4.jasper");
	  v.setReportDataKey("datasource");
	  return v;
	}

	@GetMapping(value = "AHRReport1")
	public ModelAndView getRpt2(ModelAndView modelAndView) {
		  Map<String, Object> parameterMap = new HashMap<>();
		  parameterMap.put("datasource", new JREmptyDataSource());
		  modelAndView = new ModelAndView(ahrReport, parameterMap);
		  return modelAndView;
		}
	*/
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