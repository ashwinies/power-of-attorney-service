package com.rabobank.controller;

import com.rabobank.entity.Authorization;
import com.rabobank.entity.PowerOfAttorney;
import com.rabobank.service.AuthorizationService;
import com.rabobank.service.PowerOfAttorneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class AuthorizationController {

    @Autowired
    private AuthorizationService authorizationService;

    @RequestMapping("/powerOfAttorneys/{attorneyId}/authorizations")
    public ResponseEntity<List<Authorization>> getAllAuthorizations() {
        try {
            return new ResponseEntity<>(authorizationService.getAllAuthorizations(), HttpStatus.OK);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request");
        }
    }

    @RequestMapping("/authorization/{authId}")
    public ResponseEntity<Optional<Authorization>> getAuthorization(@PathVariable Long authId) {
        try {
            return new ResponseEntity<>(authorizationService.getAuthorization(authId), HttpStatus.OK);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request");
        }
    }

}
