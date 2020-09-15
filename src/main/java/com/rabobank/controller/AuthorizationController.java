package com.rabobank.controller;

import com.rabobank.entity.Authorization;
import com.rabobank.entity.PowerOfAttorney;
import com.rabobank.service.AuthorizationService;
import com.rabobank.service.PowerOfAttorneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class AuthorizationController {

    @Autowired
    private AuthorizationService authorizationService;

    @RequestMapping("/powerOfAttorneys/{attorneyId}/authorizations")
    public List<Authorization> getAllAuthorizations() {
        return authorizationService.getAllAuthorizations();
    }

    @RequestMapping("/authorization/{authId}")
    public Optional<Authorization> getAuthorization(@PathVariable Long authorizationId) {
        return authorizationService.getAuthorization(authorizationId);
    }

}
