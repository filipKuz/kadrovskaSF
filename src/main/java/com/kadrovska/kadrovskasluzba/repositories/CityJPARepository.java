package com.kadrovska.kadrovskasluzba.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kadrovska.kadrovskasluzba.model.City;

public interface CityJPARepository extends JpaRepository<City, Long> {

	@Query("select c from City c" + " where (LOWER(c.cityName) like (CONCAT( '%', LOWER(:searchTerm), '%'))"
			+ " or c.zipCode like (CONCAT( '%', (:searchTerm), '%')))")
	Page<City> findAll(Pageable pageable, @Param("searchTerm") String searchTerm);
}