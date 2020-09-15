package com.rabobank.repository;

import com.rabobank.entity.Account;
import com.rabobank.entity.Card;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {
    public List<Account> findByPowerOfAttorneyAttorneyId(Long attorneyId);

}
