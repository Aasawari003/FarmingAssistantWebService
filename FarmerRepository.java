package com.farming.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.farming.models.Farmer;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Long> {

	Integer getFarmerIdByEmail(String email);
}