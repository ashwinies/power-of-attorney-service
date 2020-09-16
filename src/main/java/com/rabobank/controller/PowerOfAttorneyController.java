package com.rabobank.controller;

import com.rabobank.entity.Authorization;
import com.rabobank.entity.PowerOfAttorney;
import com.rabobank.service.AuthorizationService;
import com.rabobank.service.PowerOfAttorneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class PowerOfAttorneyController {

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


    @RequestMapping(method = RequestMethod.POST, value = "/powerOfAttorneys/authorizations/{authorizationType}")
    public void addPowerOfAttorneys(@RequestBody List<PowerOfAttorney> powerOfAttorneyList, @PathVariable String authorizationType) {
        String[] types = authorizationType.split(",");
        for (PowerOfAttorney attorney : powerOfAttorneyList
        ) {
            setAuthorizationForAttorney(Arrays.asList(types), attorney);
            powerOfAttorneyService.addPowerOfAttorney(attorney);
        }

    }

    private void setAuthorizationForAttorney(List<String> authTypes, PowerOfAttorney attorney) {
        for (String type : authTypes
        ) {
            Authorization authType = new Authorization(type);
            attorney.getAuthorizationSet().add(authType);
            authType.getAttorneys().add(attorney);
        }
    }
}
