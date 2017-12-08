package com.kadrovska.kadrovskasluzba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kadrovska.kadrovskasluzba.model.City;

public interface CityJPARepository extends JpaRepository<City, Long> {

}
