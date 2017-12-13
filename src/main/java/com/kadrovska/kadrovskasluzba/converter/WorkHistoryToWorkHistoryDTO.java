package com.kadrovska.kadrovskasluzba.converter;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import com.kadrovska.kadrovskasluzba.dto.WorkHistoryDTO;
import com.kadrovska.kadrovskasluzba.dto.WorkPlaceDTO;
import com.kadrovska.kadrovskasluzba.model.Employee;
import com.kadrovska.kadrovskasluzba.model.WorkHistory;
import com.kadrovska.kadrovskasluzba.model.WorkPlace;

@Component
public class WorkHistoryToWorkHistoryDTO implements Converter<WorkHistory, WorkHistoryDTO>{
	
	@Override
	public WorkHistoryDTO convert(WorkHistory wh) {
		
		WorkHistoryDTO whDTO = new WorkHistoryDTO();
		
		whDTO.setwHId(wh.getwHId());
		whDTO.setPreviousCompany(wh.getPreviousCompany());
		whDTO.setStartDate(wh.getStartDate());
		whDTO.setEndDate(wh.getEndDate());
		
		if(wh.getEmployee() != null) {
			whDTO.setEmployee(wh.getEmployee());
		}
		
		return whDTO;
	}
	
	public List<WorkHistoryDTO> convert(List<WorkHistory> whList){
		
		List<WorkHistoryDTO> retVal = new ArrayList<>();
		for (WorkHistory wh : whList) {
			retVal.add(convert(wh));
		}
		return retVal;
	}

}
