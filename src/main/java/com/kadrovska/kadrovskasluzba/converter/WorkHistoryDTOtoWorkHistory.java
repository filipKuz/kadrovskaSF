package com.kadrovska.kadrovskasluzba.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.kadrovska.kadrovskasluzba.dto.WorkHistoryDTO;
import com.kadrovska.kadrovskasluzba.model.Employee;
import com.kadrovska.kadrovskasluzba.model.WorkHistory;
import com.kadrovska.kadrovskasluzba.model.WorkPlace;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.EmployeeServiceInterface;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.WorkPlaceServiceInterface;

@Component
public class WorkHistoryDTOtoWorkHistory implements Converter<WorkHistoryDTO, WorkHistory> {

	@Autowired
	private EmployeeServiceInterface employeeService;

	@Autowired
	private WorkPlaceServiceInterface workPlaceService;

	@Override
	public WorkHistory convert(WorkHistoryDTO workHistoryDTO) {
		WorkHistory workHistory = new WorkHistory();
		
		workHistory.setCompanyName(workHistoryDTO.getPreviousCompany());
		workHistory.setStartDate(workHistoryDTO.getStartDate());
		if(workHistoryDTO.getEndDate() != null) {
			workHistory.setEndDate(workHistoryDTO.getEndDate());
		}
		
		
		Employee employee = employeeService.findOne(workHistoryDTO.getEmployeeId());
		if (employee != null) {
			workHistory.setEmployee(employee);
		}

		if(workHistoryDTO.getWorkPlaceId() != null) {
			WorkPlace workPlace = workPlaceService.findOne(workHistoryDTO.getWorkPlaceId());
			if (workPlace != null) {
				workHistory.setWorkPlace(workPlace);
			}
		}

		return workHistory;
	}
}