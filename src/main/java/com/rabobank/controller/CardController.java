package com.rabobank.controller;

import com.rabobank.entity.Card;
import com.rabobank.entity.PowerOfAttorney;
import com.rabobank.service.CardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class CardController {

    @Autowired
    private CardService cardService;

    @RequestMapping("/powerOfAttorneys/{attorneyId}/cards")
    public ResponseEntity<List<Card>> getAllCards(@PathVariable Long attorneyId) {
        log.info("Request all Cards of Attorney : " + attorneyId);
        try {
            return new ResponseEntity<>(cardService.getAllCardsByAttorneyId(attorneyId), HttpStatus.OK);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Request");
        }
    }

    @RequestMapping("/powerOfAttorneys/{attorneyId}/cards/{cardId}")
    public ResponseEntity<Optional<Card>> getCardById(@PathVariable Long cardId) {
        log.info("Request Card with id : " + cardId);
        try {
            return new ResponseEntity<>(cardService.getCard(cardId), HttpStatus.OK);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Request");
        }
    }

    @RequestMapping("/powerOfAttorneys/{attorneyId}/cards/status")
    public ResponseEntity<List<Card>> getCardsByStatus() {
        log.info("Request active Cards of attorney");
        try {
            return new ResponseEntity<>(cardService.getCardsByStatus(), HttpStatus.OK);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Request");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/powerOfAttorneys/{attorneyId}/cards")
    public ResponseEntity<Card> addPowerOfAttorneys(@RequestBody Card card, @PathVariable Long attorneyId) {
        try {
            card.setPowerOfAttorney(new PowerOfAttorney(attorneyId, "", "", "", ""));
            cardService.addCard(card);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid data");
        }
    }
}
