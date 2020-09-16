package com.rabobank.controller;

import com.rabobank.entity.Account;
import com.rabobank.entity.Card;
import com.rabobank.entity.PowerOfAttorney;
import com.rabobank.service.AccountService;
import com.rabobank.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/powerOfAttorneys/{attorneyId}/accounts")
    public List<Account> getAllAccountsByAttorneyId(@PathVariable Long attorneyId) {
        return accountService.getAllAccountsByAttorneyId(attorneyId);
    }

    @RequestMapping("/accounts/{accountId}")
    public Optional<Account> getAccountById(@PathVariable Long accountId) {
        return accountService.getAccount(accountId);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/powerOfAttorneys/{attorneyId}/accounts")
    public void addPowerOfAttorneys(@RequestBody Account account, @PathVariable Long attorneyId) {
        account.setPowerOfAttorney(new PowerOfAttorney(attorneyId, "", "", "", ""));
        accountService.addAccount(account);
    }
}
