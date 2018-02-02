package com.kadrovska.kadrovskasluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kadrovska.kadrovskasluzba.model.EmployeeChild;

public interface EmployeeChildJPARepository extends JpaRepository<EmployeeChild, Long> {

	@Query("select e from EmployeeChild e where e.parent.employeeId = :employeeId")
	List<EmployeeChild> findByEmployeeId(@Param("employeeId") long employeeId);
}
