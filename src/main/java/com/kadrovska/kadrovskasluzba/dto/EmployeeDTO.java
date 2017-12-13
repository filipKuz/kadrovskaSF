package com.kadrovska.kadrovskasluzba.dto;

import java.sql.Date;

public class EmployeeDTO {

	private Long employeeId;
	private String lastName;
	private String firstName;
	private String parentName;
	private String madenName;
	private Date birthDate;
	private String sex;
	private String address;
	private String email;
	private String phoneNumber;
	private Integer numberOfVacationDaysLeft;
	private Long cityId;
	private Long companyId;

	public EmployeeDTO() {
	}

	public EmployeeDTO(Long employeeId, String lastName, String firstName, String parentName, String madenName,
			Date birthDate, String sex, String address, String email, String phoneNumber,
			Integer numberOfVacationDaysLeft, Long cityId, Long companyId) {
		super();
		this.employeeId = employeeId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.parentName = parentName;
		this.madenName = madenName;
		this.birthDate = birthDate;
		this.sex = sex;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.numberOfVacationDaysLeft = numberOfVacationDaysLeft;
		this.cityId = cityId;
		this.companyId = companyId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getMadenName() {
		return madenName;
	}

	public void setMadenName(String madenName) {
		this.madenName = madenName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getNumberOfVacationDaysLeft() {
		return numberOfVacationDaysLeft;
	}

	public void setNumberOfVacationDaysLeft(Integer numberOfVacationDaysLeft) {
		this.numberOfVacationDaysLeft = numberOfVacationDaysLeft;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [employeeId=" + employeeId + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", parentName=" + parentName + ", madenName=" + madenName + ", birthDate=" + birthDate + ", sex="
				+ sex + ", address=" + address + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", numberOfVacationDaysLeft=" + numberOfVacationDaysLeft + ", cityId=" + cityId + ", companyId="
				+ companyId + "]";
	}
	
	
	
	

}
