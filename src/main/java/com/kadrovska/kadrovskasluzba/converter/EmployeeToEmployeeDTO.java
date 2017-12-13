package com.kadrovska.kadrovskasluzba.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.kadrovska.kadrovskasluzba.dto.EmployeeDTO;
import com.kadrovska.kadrovskasluzba.model.Employee;

@Component
public class EmployeeToEmployeeDTO implements Converter<Employee, EmployeeDTO>{

	@Override
	public EmployeeDTO convert(Employee employee) {
		
		EmployeeDTO eDTO = new EmployeeDTO();
		
		eDTO.setEmployeeId(employee.getID());
		eDTO.setAddress(employee.getAddress());
		eDTO.setLastName(employee.getLastName());
		eDTO.setFirstName(employee.getFirstName());
		eDTO.setParentName(employee.getParentName());
		eDTO.setMadenName(employee.getMadenName());
		eDTO.setBirthDate(employee.getBirthDate());
		eDTO.setSex(employee.getSex());
		eDTO.setEmail(employee.getEmail());
		eDTO.setPhoneNumber(employee.getPhoneNumber());
		eDTO.setNumberOfVacationDaysLeft(employee.getNumberOfVacationDaysLeft());
		
		if(employee.getCompany() != null) {
			eDTO.setCompanyId(employee.getCompany().getId());
		}
		
		if(employee.getCity() != null) {
			eDTO.setCityId(employee.getCity().getID());
		}
		
		return eDTO;
	}
	
	public List<EmployeeDTO> convert(List<Employee> employees) {
		
		List<EmployeeDTO> retVal = new ArrayList<>();
		
		for (Employee e: employees) {
			retVal.add(convert(e));
		}
		
		return retVal;
	}
	
}
