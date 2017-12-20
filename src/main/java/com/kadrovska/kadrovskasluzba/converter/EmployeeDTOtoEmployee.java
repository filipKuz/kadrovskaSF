package com.kadrovska.kadrovskasluzba.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.kadrovska.kadrovskasluzba.dto.EmployeeDTO;
import com.kadrovska.kadrovskasluzba.model.City;
import com.kadrovska.kadrovskasluzba.model.Company;
import com.kadrovska.kadrovskasluzba.model.Employee;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.CityServiceInterface;
import com.kadrovska.kadrovskasluzba.serviceInterfaces.CompanyServiceInterface;

@Component
public class EmployeeDTOtoEmployee implements Converter<EmployeeDTO, Employee> {

	@Autowired
	private CityServiceInterface cityService;

	@Autowired
	private CompanyServiceInterface companyService;

	@Override
	public Employee convert(EmployeeDTO employeeDTO) {

		Employee employee = new Employee();

		employee.setID(employeeDTO.getEmployeeId());
		employee.setAddress(employeeDTO.getAddress());
		employee.setLastName(employeeDTO.getLastName());
		employee.setFirstName(employeeDTO.getFirstName());
		employee.setParentName(employeeDTO.getParentName());
		employee.setMadenName(employeeDTO.getMadenName());
		employee.setBirthDate(employeeDTO.getBirthDate());
		employee.setSex(employeeDTO.getSex());
		employee.setEmail(employeeDTO.getEmail());
		employee.setPhoneNumber(employeeDTO.getPhoneNumber());

		City c = cityService.findOne(employeeDTO.getCityId());
		if (c != null) {
			employee.setCity(c);
		}

		Company comp = companyService.findOne(employeeDTO.getCompanyId());
		if (comp != null) {
			employee.setCompany(comp);
		}

		return employee;
	}
}
