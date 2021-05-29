package com.example.airmanagement.dao;

import com.example.airmanagement.models.AirCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface AirCompanyDAO extends JpaRepository<AirCompany, Integer> {

    public AirCompany findByName(String name);
}
