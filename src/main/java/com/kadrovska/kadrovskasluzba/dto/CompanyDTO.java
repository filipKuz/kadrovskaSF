package com.kadrovska.kadrovskasluzba.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class CompanyDTO {

	private Long companyId;

	@NotBlank(message = "Company name cannot be empty")
	@Length(max = 30, message = "Company name cannot contain more than 30 characters")
	private String name;

	@NotNull(message="VAT cannot be null")
	@Min(value=10000, message="VAT must be >= than 10000")
	private Long vat;

	@Length(max = 30, message = "Address cannot contain more than 30 characters")
	private String address;

	@Length(max = 30, message = "Email cannot contain more than 30 characters")
	private String email;

	@Length(max = 30, message = "Phone number cannot contain more than 15 characters")
	private String phoneNumber;

	@NotNull(message="CityId cannot be null")
	@Min(value=0, message="CityId must be >= than 0")
	private Long cityId;

	@NotNull(message="IsOurs cannot be null")
	private Boolean isOurs;

	public CompanyDTO() {
	}

	public CompanyDTO(Long companyId, String name, Long vat, String address, String email, String phoneNumber,
			Long cityId, Boolean isOurs) {
		this.companyId = companyId;
		this.name = name;
		this.vat = vat;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.cityId = cityId;
		this.isOurs = isOurs;
	}

	public Boolean getIsOurs() {
		return isOurs;
	}

	public void setIsOurs(Boolean isOurs) {
		this.isOurs = isOurs;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getVat() {
		return vat;
	}

	public void setVat(Long vat) {
		this.vat = vat;
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
}
