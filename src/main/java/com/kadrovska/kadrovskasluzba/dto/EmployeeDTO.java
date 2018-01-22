package com.kadrovska.kadrovskasluzba.dto;

import java.sql.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

public class EmployeeDTO {

	private Long employeeId;
	
	@NotBlank(message="Last name cannot be empty")
	@Length(max=30, message="Last name can not contain more than 30 characters")
	private String lastName;
	
	@NotBlank(message="Name cannot be empty")
	@Length(max=30, message="Name can not contain more than 30 characters")
	private String firstName;
	
	@NotBlank(message="Parent name cannot be empty")
	@Length(max=30, message="Parent name can not contain more than 30 characters")
	private String parentName;
	
	@Length(max=30, message="Maden name can not contain more than 30 characters")
	private String madenName;
	
	@NotNull(message="Birth date cannot be null")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthDate;
	
	@NotBlank(message="Sex cannot be empty")
	@Length(max=6, message="Description can not contain more than 6 characters")
	private String sex;
	
	@NotBlank(message="Address cannot be empty")
	@Length(max=30, message="Address can not contain more than 30 characters")
	private String address;
	
	@Length(max=30, message="Email can not contain more than 30 characters")
	private String email;
	
	@Length(max=15, message="Phone number can not contain more than 15 characters")
	private String phoneNumber;
	
	@NotNull(message="cityId cannot be null")
	@Min(value=0, message="cityId must be >= than 0")
	private Long cityId;
	
	@NotNull(message="companyId cannot be null")
	@Min(value=0, message="companyId must be >= than 0")
	private Long companyId;

	public EmployeeDTO() {
	}

	public EmployeeDTO(Long employeeId, String lastName, String firstName, String parentName, String madenName,
			Date birthDate, String sex, String address, String email, String phoneNumber, Long cityId, Long companyId) {
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
				+ sex + ", address=" + address + ", email=" + email + ", phoneNumber=" + phoneNumber + ", cityId="
				+ cityId + ", companyId=" + companyId + "]";
	}
	
	
}
