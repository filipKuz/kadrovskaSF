package com.kadrovska.kadrovskasluzba.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import com.kadrovska.kadrovskasluzba.dto.WorkHistoryDTO;
import com.kadrovska.kadrovskasluzba.model.Employee;
import com.kadrovska.kadrovskasluzba.model.WorkHistory;
import com.kadrovska.kadrovskasluzba.model.WorkPlace;
import com.kadrovska.kadrovskasluzba.serviceInterfaceImplementation.EmployeeService;
import com.kadrovska.kadrovskasluzba.serviceInterfaceImplementation.WorkPlaceService;

public class WorkHistoryDTOtoWorkHistory implements Converter<WorkHistoryDTO, WorkHistory>{
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private WorkPlaceService workPlaceService;
	
	@Override
	public WorkHistory convert(WorkHistoryDTO whDTO) {
		WorkHistory wh = new WorkHistory();
		
		wh.setwHId(whDTO.getwHId());
		wh.setPreviousCompany(whDTO.getPreviousCompany());
		wh.setStartDate(whDTO.getStartDate());
		wh.setEndDate(whDTO.getEndDate());
		
		Employee e = employeeService.findOne(whDTO.getwHId());
			if (e != null) {
				wh.setEmployee(e);
				
			}
			
		WorkPlace wp = workPlaceService.findOne(whDTO.getWorkPlace().getWorkplaceId());
		if (wp != null) {
			wh.setWorkPlace(wp);
			
		}
		return wh;
			
	}

}
