package com.rabobank.controller;

import com.rabobank.entity.Authorization;
import com.rabobank.entity.Card;
import com.rabobank.entity.PowerOfAttorney;
import com.rabobank.service.AuthorizationService;
import com.rabobank.service.CardService;
import com.rabobank.service.PowerOfAttorneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class AuthorizationController {

    @Autowired
    private AuthorizationService authorizationService;
    @Autowired
    private PowerOfAttorneyService powerOfAttorneyService;

    @RequestMapping("/powerOfAttorneys/{attorneyId}/authorizations")
    public List<Authorization> getAllAuths(@PathVariable Long attorneyId) {
        return authorizationService.getAllAuthos(attorneyId);
    }

   /* @RequestMapping("/powerOfAttorneys/{attorneyId}/cards/{cardId}")
    public Optional<Authorization> getCardById(@PathVariable Long cardId) {
        return authorizationService.getCard(cardId);
    }*/

    /*@RequestMapping("/powerOfAttorneys/{attorneyId}/cards/status")
    public List<Authorization> getCardsByStatus() {
        return authorizationService.getAllCards();
    }*/

    @RequestMapping(method = RequestMethod.POST, value = "/powerOfAttorneys/{attorneyId}/{authorizationType}")
    public void addPowerOfAttorneys(@RequestBody Authorization authorization, @PathVariable Long attorneyId, @PathVariable String authorizationType) {
        List<Authorization> authList=new ArrayList<>();
        String [] types=authorizationType.split(",");
        for (String type: types
             ) {
            Authorization viewAuth = new Authorization(type);
            authList.add(viewAuth);
        }
        authorizationService.saveAll(authList);
        Optional<PowerOfAttorney> powerOfAttorney = powerOfAttorneyService.getPowerOfAttorney(attorneyId);
        powerOfAttorney.get().getAuthorizationSet().addAll(authList);
        powerOfAttorneyService.addPowerOfAttorney(powerOfAttorney.get());
    }
}
