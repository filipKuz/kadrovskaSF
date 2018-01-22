package com.kadrovska.kadrovskasluzba.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class NonworkingDay {

	@Id
	@GeneratedValue
	private Long nonWorkingDayId;

	@NotBlank(message="Description cannot be empty")
	@Length(max=30, message="Description can not contain more than 30 characters")
	@Column(nullable = false, columnDefinition="VARCHAR(30)")
	private String nonworkingDayDescription;

	
	@NotNull(message="Date cannot be null")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(nullable = false)
	private Date nonworkingDayDate;

	

	public NonworkingDay() {
	}

	public Long getNonWorkingDayId() {
		return nonWorkingDayId;
	}

	public void setNonWorkingDayId(Long nonWorkingDayId) {
		this.nonWorkingDayId = nonWorkingDayId;
	}

	public String getNonworkingDayDescription() {
		return nonworkingDayDescription;
	}

	public void setNonworkingDayDescription(String nonworkingDayDescription) {
		this.nonworkingDayDescription = nonworkingDayDescription;
	}

	public Date getNonworkingDayDate() {
		return nonworkingDayDate;
	}

	public void setNonworkingDayDate(Date nonworkingDayDate) {
		this.nonworkingDayDate = nonworkingDayDate;
	}

	
}
