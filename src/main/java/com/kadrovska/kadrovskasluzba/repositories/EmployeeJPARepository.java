package com.kadrovska.kadrovskasluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.kadrovska.kadrovskasluzba.model.Employee;

public interface EmployeeJPARepository extends JpaRepository<Employee, Long> {
	
	@Modifying
	@Query("select e from Employee e, WorkHistory wh where e.employeeId = wh.employee and wh.endDate is NULL")
	List<Employee> findActiveEmployees();
	
}
