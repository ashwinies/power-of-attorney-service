package com.rabobank.service;

import com.rabobank.entity.Authorization;
import com.rabobank.repository.AuthorizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorizationService {

    @Autowired
    private AuthorizationRepository authorizationRepository;

    public List<Authorization> getAllAuthos(Long id) {
        List<Authorization> authorizations = new ArrayList<>();
        authorizationRepository.findAll().forEach(authorizations::add);
        return authorizations;
    }

   /* public Optional<Authorization> getCard(Long id) {
        return authorizationRepository.findById(id);
    }*/

   /* public List<Card> getCardsByStatus() {

        return (List<Card>) authorizationRepository.findAllActiveCards();
    }*/

    public void saveAll(List<Authorization> authorizations) {
        authorizationRepository.saveAll(authorizations);
    }
}
