package com.kadrovska.kadrovskasluzba.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kadrovska.kadrovskasluzba.dto.AnnualHolidayRegulationDTO;
import com.kadrovska.kadrovskasluzba.model.AnnualHolidayRegulation;

@Component
public class AHRtoAHRDTO implements Converter<AnnualHolidayRegulation,AnnualHolidayRegulationDTO> {

	@Autowired
	EmployeeToEmployeeDTO toEmployeeDTO;
	
	@Override
	public AnnualHolidayRegulationDTO convert(AnnualHolidayRegulation arg0) {
		AnnualHolidayRegulationDTO ahrDTO = new AnnualHolidayRegulationDTO();
		
		ahrDTO.setAnnualHolidayRegulationId(arg0.getAnnualHolidayRegulationId());
		ahrDTO.setBusinessYear(arg0.getBusinessYear());
		ahrDTO.setNumOfDays(arg0.getNumOfDays());
		if (arg0.getEmployee()!=null){
			ahrDTO.setEmployeeDTO(toEmployeeDTO.convert(arg0.getEmployee()));
		}
		
		return ahrDTO;
	}
	
	public List<AnnualHolidayRegulationDTO> convert(List<AnnualHolidayRegulation> annualHolidayRegulations) {

		List<AnnualHolidayRegulationDTO> retVal = new ArrayList<>();

		for (AnnualHolidayRegulation a : annualHolidayRegulations) {
			retVal.add(convert(a));
		}

		return retVal;
	}
	
}
