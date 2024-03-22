package com.farming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farming.models.Farmer;
import com.farming.repository.FarmerRepository;

@Service
public class FarmerService {

	@Autowired
    private FarmerRepository farmerRepository;

    public Integer getFarmerIdByEmail(String email) {
        return farmerRepository.getFarmerIdByEmail(email);
    }
}
