package com.kadrovska.kadrovskasluzba.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class NonworkingDay {

	@Id
	@GeneratedValue
	private Long nonWorkingDayId;

	@Column(nullable = false, columnDefinition="VARCHAR(30)")
	private String nonworkingDayDescription;

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
