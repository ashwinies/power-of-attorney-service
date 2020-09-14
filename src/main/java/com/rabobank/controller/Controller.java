package com.rabobank.controller;

import com.rabobank.entity.PowerOfAttorney;
import com.rabobank.service.PowerOfAttorneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    private PowerOfAttorneyService powerOfAttorneyService;

    @RequestMapping("/powerOfAttorneys")
    public List<PowerOfAttorney> getAllPowerOfAttorneys() {
        return powerOfAttorneyService.getAllPowerOfAttorneys();
    }

    @RequestMapping("/powerOfAttorneys/{attorneyId}")
    public Optional<PowerOfAttorney> getPowerOfAttorney(@PathVariable Long attorneyId) {

        return powerOfAttorneyService.getPowerOfAttorney(attorneyId);
    }

    @RequestMapping(method = RequestMethod.POST, value="/powerOfAttorneys")
    public void addPowerOfAttorneys(@RequestBody PowerOfAttorney powerOfAttorney) {
        powerOfAttorneyService.addPowerOfAttorney(powerOfAttorney);
    }
}
