package com.kadrovska.kadrovskasluzba.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.kadrovska.kadrovskasluzba.dto.EmployeeDTO;
import com.kadrovska.kadrovskasluzba.model.City;
import com.kadrovska.kadrovskasluzba.model.Company;
import com.kadrovska.kadrovskasluzba.model.Employee;
import com.kadrovska.kadrovskasluzba.services.CityService;
import com.kadrovska.kadrovskasluzba.services.CompanyService;

@Component
public class EmployeeDTOtoEmployee implements Converter<EmployeeDTO, Employee> {

	@Autowired
	private CityService cityService;
	@Autowired
	private CompanyService companyService;

	@Override
	public Employee convert(EmployeeDTO a) {

		Employee e = new Employee();

		e.setID(a.getEmployeeId());
		e.setAddress(a.getAddress());
		e.setLastName(a.getLastName());
		e.setFirstName(a.getFirstName());
		e.setParentName(a.getParentName());
		e.setMadenName(a.getMadenName());
		e.setBirthDate(a.getBirthDate());
		e.setSex(a.getSex());
		e.setEmail(a.getEmail());
		e.setPhoneNumber(a.getPhoneNumber());

		City c = cityService.findOne(a.getCityId());
		if (c != null) {
			e.setCity(c);
		}

		Company comp = companyService.findOne(a.getCompanyId());
		if (comp != null) {
			e.setCompany(comp);
		}

		return e;
	}

}
