package com.rabobank.service;

import com.rabobank.entity.Authorization;
import com.rabobank.repository.AuthorizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorizationService {

    @Autowired
    private AuthorizationRepository authorizationRepository;

    public List<Authorization> getAllAuthorizations() throws IOException {
        List<Authorization> authorizations = new ArrayList<>();
        authorizationRepository.findAll().forEach(authorizations::add);
        return authorizations;
    }

    public Optional<Authorization> getAuthorization(Long authorizationId) throws IOException{
        return authorizationRepository.findById(authorizationId);
    }


    public void saveAll(List<Authorization> authorizations)throws IOException {
        authorizationRepository.saveAll(authorizations);
    }
}
