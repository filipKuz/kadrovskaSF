package com.kadrovska.kadrovskasluzba.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Long employeeId;

	@Size(min=2, max=15)
	@NotNull
	@Column(nullable = false, length=15)
	private String lastName;

	@Size(min=2,max=15)
	@NotNull
	@Column(nullable = false, length=15)
	private String firstName;

	@Size(min=2,max=15)
	@NotNull
	@Column(nullable = false, length=15)
	private String parentName;

	@Size(max=15)
	@Column(length=15)
	private String madenName;

	@NotNull
	@Column(nullable = false)
	private Date birthDate;

	@NotNull
	@Size(min=1, max=1)
	@Column(nullable = false, length=1)
	private String sex;
	
	@Size(max=45)
	@Column(nullable = false, length=45)
	private String address;

	@Size(max=30)
	@Column(length=30)
	private String email;

	@Size(max=20)
	@Column(length=20)
	private String phoneNumber;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "companyId")
	private Company company;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
	private Set<EmployeeChild> children = new HashSet<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	private Set<EmployeeProfessionalQualification> professionalQualifications = new HashSet<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	private Set<AnnualHolidayRegulation> annualHolidayRegulations = new HashSet<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	private Set<WorkHistory> workingHistory = new HashSet<>();

	@ManyToOne
	@NotNull
	@JoinColumn(name = "cityId", nullable=false)
	private City city;

	public Employee() {
	}

	public long getID() {
		return employeeId;
	}

	public void setID(long iD) {
		employeeId = iD;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Set<EmployeeChild> getChildren() {
		return children;
	}

	public void setChildren(Set<EmployeeChild> children) {
		this.children = children;
	}

	public Set<EmployeeProfessionalQualification> getProfessionalQualifications() {
		return professionalQualifications;
	}

	public void setProfessionalQualifications(Set<EmployeeProfessionalQualification> professionalQualifications) {
		this.professionalQualifications = professionalQualifications;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Set<AnnualHolidayRegulation> getAnnualHolidayRegulations() {
		return annualHolidayRegulations;
	}

	public void setAnnualHolidayRegulations(Set<AnnualHolidayRegulation> annualHolidayRegulations) {
		this.annualHolidayRegulations = annualHolidayRegulations;
	}

	public Set<WorkHistory> getWorkingHistory() {
		return workingHistory;
	}

	public void setWorkingHistory(Set<WorkHistory> workingHistory) {
		this.workingHistory = workingHistory;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
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
}
