package com.example.airmanagement.dao;

import com.example.airmanagement.models.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface AirPlaneDAO extends JpaRepository<Airplane, Integer> {
}
