package com.kadrovska.kadrovskasluzba.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.kadrovska.kadrovskasluzba.dto.EmployeeDTO;
import com.kadrovska.kadrovskasluzba.model.Employee;

@Component
public class EmployeeToEmployeeDTO implements Converter<Employee, EmployeeDTO> {

	@Override
	public EmployeeDTO convert(Employee employee) {

		EmployeeDTO employeeDTO = new EmployeeDTO();

		employeeDTO.setEmployeeId(employee.getID());
		employeeDTO.setAddress(employee.getAddress());
		employeeDTO.setLastName(employee.getLastName());
		employeeDTO.setFirstName(employee.getFirstName());
		employeeDTO.setParentName(employee.getParentName());
		employeeDTO.setMadenName(employee.getMadenName());
		employeeDTO.setBirthDate(employee.getBirthDate());
		employeeDTO.setSex(employee.getSex());
		employeeDTO.setEmail(employee.getEmail());
		employeeDTO.setPhoneNumber(employee.getPhoneNumber());

		if (employee.getCompany() != null) {
			employeeDTO.setCompanyId(employee.getCompany().getId());
		}
		
		if(employee.getCity() != null) {
			employeeDTO.setCityId(employee.getCity().getID());
		}
		
		return employeeDTO;
	}

	public List<EmployeeDTO> convert(List<Employee> employees) {

		List<EmployeeDTO> retVal = new ArrayList<>();

		for (Employee e : employees) {
			retVal.add(convert(e));
		}

		return retVal;
	}

}
