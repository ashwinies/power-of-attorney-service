package com.rabobank.service;

import com.rabobank.entity.Authorization;
import com.rabobank.repository.AuthorizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorizationService {

    @Autowired
    private AuthorizationRepository authorizationRepository;

    public List<Authorization> getAllAuthorizations() {
        List<Authorization> authorizations = new ArrayList<>();
        authorizationRepository.findAll().forEach(authorizations::add);
        return authorizations;
    }

    public Optional<Authorization> getAuthorization(Long authorizationId) {
        return authorizationRepository.findById(authorizationId);
    }


    public void saveAll(List<Authorization> authorizations) {
        authorizationRepository.saveAll(authorizations);
    }
}
