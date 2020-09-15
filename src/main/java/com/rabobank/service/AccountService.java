package com.rabobank.service;

import com.rabobank.entity.Account;
import com.rabobank.entity.Card;
import com.rabobank.repository.AccountRepository;
import com.rabobank.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccountsByAttorneyId(Long id) {
        List<Account> accounts = new ArrayList<>();
        accountRepository.findByPowerOfAttorneyAttorneyId(id).forEach(accounts::add);
        return accounts;
    }

    public Optional<Account> getAccount(Long id) {
        return accountRepository.findById(id);
    }

    public void addAccount(Account account) {
        accountRepository.save(account);
    }
}
