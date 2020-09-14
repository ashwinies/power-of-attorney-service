package com.rabobank.service;

import com.rabobank.entity.Card;
import com.rabobank.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorizationService {

    @Autowired
    private CardRepository cardRepository;

    public List<Card> getAllCards(Long id) {
        List<Card> cards = new ArrayList<>();
        cardRepository.findByPowerOfAttorneyAttorneyId(id).forEach(cards::add);
        return cards;
    }

    public Optional<Card> getCard(Long id) {
        return cardRepository.findById(id);
    }

    public List<Card> getCardsByStatus() {

        return (List<Card>) cardRepository.findAllActiveCards();
    }

    public void addCard(Card card) {
        cardRepository.save(card);
    }
}
