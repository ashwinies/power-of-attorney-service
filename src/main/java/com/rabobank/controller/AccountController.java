package com.rabobank.controller;

import com.rabobank.entity.Account;
import com.rabobank.entity.Card;
import com.rabobank.entity.PowerOfAttorney;
import com.rabobank.service.AccountService;
import com.rabobank.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/powerOfAttorneys/{attorneyId}/accounts")
    public ResponseEntity<List<Account>> getAllAccountsByAttorneyId(@PathVariable Long attorneyId) {
        try {
            return new ResponseEntity<>(accountService.getAllAccountsByAttorneyId(attorneyId), HttpStatus.OK);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request");
        }
    }

    @RequestMapping("/accounts/{accountId}")
    public ResponseEntity<Optional<Account>> getAccountById(@PathVariable Long accountId) {
        try {
            return new ResponseEntity<>(accountService.getAccount(accountId), HttpStatus.OK);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request");
        }
    }


    @RequestMapping(method = RequestMethod.POST, value = "/powerOfAttorneys/{attorneyId}/accounts")
    public ResponseEntity<Account> addPowerOfAttorneys(@RequestBody Account account, @PathVariable Long attorneyId) {
        try {
            account.setPowerOfAttorney(new PowerOfAttorney(attorneyId, "", "", "", ""));
            accountService.addAccount(account);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid data");
        }
    }
}
