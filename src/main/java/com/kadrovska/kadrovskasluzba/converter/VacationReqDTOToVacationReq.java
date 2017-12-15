package com.kadrovska.kadrovskasluzba.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.kadrovska.kadrovskasluzba.dto.VacationRequestDTO;
import com.kadrovska.kadrovskasluzba.model.AnnualHolidayRegulation;
import com.kadrovska.kadrovskasluzba.model.VacationRequest;
import com.kadrovska.kadrovskasluzba.services.AnnualHolidayRegulationService;

@Component
public class VacationReqDTOToVacationReq implements Converter<VacationRequestDTO, VacationRequest> {

	@Autowired
	private AnnualHolidayRegulationService annualHolidayRegulationService;

	@Override
	public VacationRequest convert(VacationRequestDTO vDTO) {
		VacationRequest v = new VacationRequest();
		v.setvRId(vDTO.getVacationRequestId());
		v.setStrDate(vDTO.getStartDate());
		v.setEndDate(vDTO.getEndDate());
		v.setNumOfDays(vDTO.getNumOfDays());

		AnnualHolidayRegulation a = annualHolidayRegulationService.findOne(vDTO.getAnnualHolidayRegulationId());
		if (a != null) {
			v.setAnnualHolidayRegulation(a);
		}

		return v;
	}
}