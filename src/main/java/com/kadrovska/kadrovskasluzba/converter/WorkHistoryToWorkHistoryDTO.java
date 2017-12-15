package com.kadrovska.kadrovskasluzba.converter;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import org.springframework.core.convert.converter.Converter;
import com.kadrovska.kadrovskasluzba.dto.WorkHistoryDTO;
import com.kadrovska.kadrovskasluzba.model.WorkHistory;

@Component
public class WorkHistoryToWorkHistoryDTO implements Converter<WorkHistory, WorkHistoryDTO> {

	@Override
	public WorkHistoryDTO convert(WorkHistory workHistory) {

		WorkHistoryDTO workHistoryDTO = new WorkHistoryDTO();

		workHistoryDTO.setWorkHistoryId(workHistory.getWorkHistoryId());
		workHistoryDTO.setPreviousCompany(workHistory.getPreviousCompany());
		workHistoryDTO.setStartDate(workHistory.getStartDate());
		workHistoryDTO.setEndDate(workHistory.getEndDate());

		if (workHistory.getEmployee() != null) {
			workHistoryDTO.setEmployeeId(workHistory.getEmployee().getEmployeeId());
		}

		return workHistoryDTO;
	}

	public List<WorkHistoryDTO> convert(List<WorkHistory> whList) {

		List<WorkHistoryDTO> retVal = new ArrayList<>();
		for (WorkHistory wh : whList) {
			retVal.add(convert(wh));
		}
		return retVal;
	}
}