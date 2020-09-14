package com.rabobank.service;

import com.rabobank.entity.PowerOfAttorney;
import com.rabobank.repository.PowerOfAttorneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PowerOfAttorneyService {

    @Autowired
    private PowerOfAttorneyRepository powerOfAttorneyRepository;

    public List<PowerOfAttorney> getAllPowerOfAttorneys() {
        List<PowerOfAttorney> powerOfAttorneys = new ArrayList<>();
        powerOfAttorneyRepository.findAll().forEach(powerOfAttorneys::add);
        return powerOfAttorneys;
    }

    public Optional<PowerOfAttorney> getPowerOfAttorney(Long attorneyId) {
        return powerOfAttorneyRepository.findById(attorneyId);
    }

    public void addPowerOfAttorney(PowerOfAttorney powerOfAttorney) {
        powerOfAttorneyRepository.save(powerOfAttorney);
    }
}
