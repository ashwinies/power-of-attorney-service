package com.rabobank.controller;

import com.rabobank.entity.Authorization;
import com.rabobank.entity.PowerOfAttorney;
import com.rabobank.service.PowerOfAttorneyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class PowerOfAttorneyController {

    @Autowired
    private PowerOfAttorneyService powerOfAttorneyService;

    @RequestMapping("/powerOfAttorneys")
    public ResponseEntity<List<PowerOfAttorney>> getAllPowerOfAttorneys() {
        log.info("Request for Attorneys");
        try {
            return new ResponseEntity<>(powerOfAttorneyService.getAllPowerOfAttorneys(), HttpStatus.OK);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request");
        }

    }

    @RequestMapping("/powerOfAttorneys/{attorneyId}")
    public ResponseEntity<Optional<PowerOfAttorney>> getPowerOfAttorney(@PathVariable Long attorneyId) {
        log.info("Request for Attorney with id : " + attorneyId);
        try {
            return new ResponseEntity<>(powerOfAttorneyService.getPowerOfAttorney(attorneyId), HttpStatus.OK);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Request");
        }
    }


    @RequestMapping(method = RequestMethod.POST, value = "/powerOfAttorneys/authorizations/{authorizationType}")
    public ResponseEntity<PowerOfAttorney> addPowerOfAttorneys(@RequestBody List<PowerOfAttorney> powerOfAttorneyList, @PathVariable String authorizationType) {
        log.info("Save Attorney details : ");
        ResponseEntity response = null;
        String[] types = authorizationType.split(",");
        for (PowerOfAttorney attorney : powerOfAttorneyList) {
            try {
                setAuthorizationForAttorney(Arrays.asList(types), attorney);
                powerOfAttorneyService.addPowerOfAttorney(attorney);
                response = new ResponseEntity<>(HttpStatus.ACCEPTED);
            } catch (IOException e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid data");
            }
        }

        return response;
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
