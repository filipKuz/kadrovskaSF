package com.kadrovska.kadrovskasluzba.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.kadrovska.kadrovskasluzba.dto.EmployeeChildDTO;
import com.kadrovska.kadrovskasluzba.model.EmployeeChild;

@Component
public class EmployeeChildToEmployeeChildDTO implements Converter<EmployeeChild, EmployeeChildDTO> {

	@Override
	public EmployeeChildDTO convert(EmployeeChild employeeChild) {
		EmployeeChildDTO childDTO = new EmployeeChildDTO();

		childDTO.setEmployeeChildId(employeeChild.getID());
		childDTO.setName(employeeChild.getName());
		childDTO.setLastName(employeeChild.getLastName());
		childDTO.setBirthDate(employeeChild.getBirthDate());
		childDTO.setParentId(employeeChild.getParent().getID());
		childDTO.setSex(employeeChild.getSex());

		return childDTO;
	}

	public List<EmployeeChildDTO> convert(List<EmployeeChild> EmployeeChildren) {

		List<EmployeeChildDTO> retVal = new ArrayList<>();

		for (EmployeeChild e : EmployeeChildren) {
			retVal.add(convert(e));
		}

		return retVal;
	}
}
