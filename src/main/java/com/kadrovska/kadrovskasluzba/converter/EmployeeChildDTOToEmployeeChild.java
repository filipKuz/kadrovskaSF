package com.kadrovska.kadrovskasluzba.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.kadrovska.kadrovskasluzba.dto.EmployeeChildDTO;
import com.kadrovska.kadrovskasluzba.model.Employee;
import com.kadrovska.kadrovskasluzba.model.EmployeeChild;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.EmployeeServiceInterface;

@Component
public class EmployeeChildDTOToEmployeeChild implements Converter<EmployeeChildDTO, EmployeeChild> {

	@Autowired
	private EmployeeServiceInterface employeeService;

	@Override
	public EmployeeChild convert(EmployeeChildDTO employeeChildDTO) {
		EmployeeChild employeeChild = new EmployeeChild();

		employeeChild.setID(employeeChildDTO.getEmployeeChildId());
		employeeChild.setName(employeeChildDTO.getName());
		employeeChild.setLastName(employeeChildDTO.getLastName());
		employeeChild.setBirthDate(employeeChildDTO.getBirthDate());
		employeeChild.setSex(employeeChildDTO.getSex());
		Employee parent = employeeService.findOne(employeeChildDTO.getParentId());

		if (parent != null) {
			employeeChild.setParent(parent);
		}

		return employeeChild;
	}

}
