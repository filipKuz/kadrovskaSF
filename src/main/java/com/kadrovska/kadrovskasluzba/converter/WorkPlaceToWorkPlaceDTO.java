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
	public WorkPlaceDTO convert(WorkPlace wp) {

		WorkPlaceDTO wpDTO = new WorkPlaceDTO();

		wpDTO.setWorkPlaceId(wp.getWorkPlaceId());
		wpDTO.setName(wp.getName());
		wpDTO.setCoefficient(wp.getCoefficient());

		return wpDTO;
	}

	public List<WorkPlaceDTO> convert(List<WorkPlace> wpList) {

		List<WorkPlaceDTO> retVal = new ArrayList<>();
		for (WorkPlace wp : wpList) {
			retVal.add(convert(wp));
		}
		return retVal;
	}
}