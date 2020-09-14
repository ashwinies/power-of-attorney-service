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
    public List<Card> getAllPowerOfAttorneys(@PathVariable Long attorneyId) {
        return cardService.getAllCards(attorneyId);
    }

    @RequestMapping("/powerOfAttorneys/{attorneyId}/cards/{cardId}")
    public Optional<Card> getPowerOfAttorney(@PathVariable Long cardId) {
        return cardService.getCard(cardId);
    }

    @RequestMapping("/powerOfAttorneys/{attorneyId}/cards/status")
    public List<Card> getCradsByStatus() {
        return cardService.getCardByStatus();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/powerOfAttorneys/{attorneyId}/cards")
    public void addPowerOfAttorneys(@RequestBody Card card, @PathVariable Long attorneyId) {
        card.setPowerOfAttorney(new PowerOfAttorney(attorneyId, "", "", "", ""));
        cardService.addCard(card);
    }
}
