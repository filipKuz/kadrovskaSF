package com.kadrovska.kadrovskasluzba.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class CityDTO {

	private Long cityId;

	@NotBlank(message = "City name cannot be empty")
	@Length(max = 30, message = "City name cannot contain more than 30 characters")
	private String cityName;

	@NotNull(message="Zip code cannot be null")
	@Min(value=0, message="Zip code must be >= than 0")
	private Integer zipCode;

	public CityDTO() {
	}

	public CityDTO(Long cityId, String cityName, Integer zipCode) {
		this.cityId = cityId;
		this.cityName = cityName;
		this.zipCode = zipCode;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
}
