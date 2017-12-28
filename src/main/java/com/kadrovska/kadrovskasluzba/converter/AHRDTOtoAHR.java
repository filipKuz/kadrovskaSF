package com.kadrovska.kadrovskasluzba.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.kadrovska.kadrovskasluzba.dto.AnnualHolidayRegulationDTO;
import com.kadrovska.kadrovskasluzba.model.AnnualHolidayRegulation;
import com.kadrovska.kadrovskasluzba.model.Employee;
import com.kadrovska.kadrovskasluzba.services.AnnualHolidayRegulationService;
import com.kadrovska.kadrovskasluzba.services.EmployeeService;

@Component
public class AHRDTOtoAHR implements Converter<AnnualHolidayRegulationDTO, AnnualHolidayRegulation> {

	@Autowired
	AnnualHolidayRegulationService annualHolidayRegulationService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Override
	public AnnualHolidayRegulation convert(AnnualHolidayRegulationDTO arg0) {
		AnnualHolidayRegulation ahr = new AnnualHolidayRegulation();
		ahr.setAnnualHolidayRegulationId(arg0.getAnnualHolidayRegulationId());;
		ahr.setBusinessYear(arg0.getBusinessYear());
		ahr.setNumOfDays(arg0.getNumOfDays());

		Employee e = employeeService.findOne(arg0.getEmployeeDTO().getEmployeeId());
		if (e != null) {
			ahr.setEmployee(e);;
		}

		return ahr;
	}
	

	
	
}
