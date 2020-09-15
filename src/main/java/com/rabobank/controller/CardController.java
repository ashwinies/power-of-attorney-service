package com.rabobank.controller;

import com.rabobank.entity.Card;
import com.rabobank.entity.PowerOfAttorney;
import com.rabobank.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CardController {

    @Autowired
    private CardService cardService;

    @RequestMapping("/powerOfAttorneys/{attorneyId}/cards")
    public List<Card> getAllCards(@PathVariable Long attorneyId) {
        return cardService.getAllCardsByAttorneyId(attorneyId);
    }

    @RequestMapping("/powerOfAttorneys/{attorneyId}/cards/{cardId}")
    public Optional<Card> getCardById(@PathVariable Long cardId) {
        return cardService.getCard(cardId);
    }

    @RequestMapping("/powerOfAttorneys/{attorneyId}/cards/status")
    public List<Card> getCardsByStatus() {
        return cardService.getCardsByStatus();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/powerOfAttorneys/{attorneyId}/cards")
    public void addPowerOfAttorneys(@RequestBody Card card, @PathVariable Long attorneyId) {
        card.setPowerOfAttorney(new PowerOfAttorney(attorneyId, "", "", "", ""));
        cardService.addCard(card);
    }
}
