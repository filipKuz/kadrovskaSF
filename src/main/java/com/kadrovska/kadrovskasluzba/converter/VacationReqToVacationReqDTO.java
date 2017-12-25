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
	public VacationRequestDTO convert(VacationRequest vacationRequest) {

		VacationRequestDTO vDTO = new VacationRequestDTO();
		vDTO.setVacationRequestId(vacationRequest.getId());
		vDTO.setAnnualHolidayRegulationId(vacationRequest.getAnnualHolidayRegulation().getAnnualHolidayRegulationId());
		vDTO.setStartDate(vacationRequest.getStrDate());
		vDTO.setEndDate(vacationRequest.getEndDate());
		vDTO.setNumOfDays(vacationRequest.getNumOfDays());
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
