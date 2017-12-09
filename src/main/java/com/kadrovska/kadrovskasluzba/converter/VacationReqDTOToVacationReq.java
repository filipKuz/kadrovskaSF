package com.kadrovska.kadrovskasluzba.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.kadrovska.kadrovskasluzba.dto.VacationRequestDTO;
import com.kadrovska.kadrovskasluzba.model.Employee;
import com.kadrovska.kadrovskasluzba.model.VacationRequest;
import com.kadrovska.kadrovskasluzba.serviceInterfaceImplementation.EmployeeService;

@Component
public class VacationReqDTOToVacationReq implements Converter<VacationRequestDTO, VacationRequest> {

	@Autowired
	private EmployeeService employeeService;
	
	@Override
	public VacationRequest convert(VacationRequestDTO vDTO){
		VacationRequest v = new VacationRequest();
		v.setvRId(vDTO.getvRId());
		v.setStrDate(vDTO.getStrDate());
		v.setEndDate(vDTO.getEndDate());
		v.setApproved(vDTO.getApproved());
		
		Employee e = employeeService.findOne(vDTO.getEmployeeId());
		if(e != null){
			v.setEmployee(e);
		}
		
		return v;
		
	}
}
