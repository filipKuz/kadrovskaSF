package com.kadrovska.kadrovskasluzba.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.kadrovska.kadrovskasluzba.dto.VacationRequestDTO;
import com.kadrovska.kadrovskasluzba.model.VacationRequest;

@Component
public class VacationReqToVacationReqDTO implements Converter<VacationRequest, VacationRequestDTO> {

	@Override
	public VacationRequestDTO convert(VacationRequest arg0) {

		VacationRequestDTO vDTO = new VacationRequestDTO();
		vDTO.setVacationRequestId(arg0.getId());
		vDTO.setAnnualHolidayRegulationId(arg0.getAnnualHolidayRegulation().getAnnualHolidayRegulationId());
		vDTO.setStartDate(arg0.getStrDate());
		vDTO.setEndDate(arg0.getEndDate());
		vDTO.setNumOfDays(arg0.getNumOfDays());
		return vDTO;

	}

	public List<VacationRequestDTO> convert(List<VacationRequest> VacationRequests) {

		List<VacationRequestDTO> retVal = new ArrayList<>();

		for (VacationRequest vr : VacationRequests) {
			retVal.add(convert(vr));
		}
		return retVal;
	}
}
