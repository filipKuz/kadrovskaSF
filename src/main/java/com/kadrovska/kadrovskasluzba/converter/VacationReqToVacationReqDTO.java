package com.kadrovska.kadrovskasluzba.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.kadrovska.kadrovskasluzba.dto.EmployeeChildDTO;
import com.kadrovska.kadrovskasluzba.dto.VacationRequestDTO;
import com.kadrovska.kadrovskasluzba.model.Employee;
import com.kadrovska.kadrovskasluzba.model.EmployeeChild;
import com.kadrovska.kadrovskasluzba.model.VacationRequest;

@Component
public class VacationReqToVacationReqDTO implements Converter<VacationRequest, VacationRequestDTO> {

	@Override
	public VacationRequestDTO convert(VacationRequest arg0) {

		VacationRequestDTO vDTO = new VacationRequestDTO();
		vDTO.setvRId(arg0.getId());
		vDTO.setEmployeeId(arg0.getEmployee().getID());
		vDTO.setStrDate(arg0.getStrDate());
		vDTO.setEndDate(arg0.getEndDate());
		vDTO.setApproved(arg0.getApproved());
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
