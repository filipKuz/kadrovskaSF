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

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private Date date;

	public NonworkingDay(String description, Date date) {
		this.description = description;
		this.date = date;
	}

	public Long getNonWorkingDayId() {
		return nonWorkingDayId;
	}

	public void setNonWorkingDayId(Long nonWorkingDayId) {
		this.nonWorkingDayId = nonWorkingDayId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
