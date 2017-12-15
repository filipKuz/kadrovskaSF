package com.kadrovska.kadrovskasluzba.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import org.springframework.core.convert.converter.Converter;
import com.kadrovska.kadrovskasluzba.dto.WorkPlaceDTO;
import com.kadrovska.kadrovskasluzba.model.WorkPlace;

@Component
public class WorkPlaceToWorkPlaceDTO implements Converter<WorkPlace, WorkPlaceDTO> {

	@Override
	public WorkPlaceDTO convert(WorkPlace workPlace) {

		WorkPlaceDTO workPlaceDTO = new WorkPlaceDTO();

		workPlaceDTO.setWorkPlaceId(workPlace.getWorkPlaceId());
		workPlaceDTO.setName(workPlace.getName());
		workPlaceDTO.setCoefficient(workPlace.getCoefficient());

		return workPlaceDTO;
	}

	public List<WorkPlaceDTO> convert(List<WorkPlace> wpList) {

		List<WorkPlaceDTO> retVal = new ArrayList<>();
		for (WorkPlace wp : wpList) {
			retVal.add(convert(wp));
		}
		return retVal;
	}
}