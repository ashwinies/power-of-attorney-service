package com.rabobank.repository;

import com.rabobank.entity.Card;
import com.rabobank.entity.PowerOfAttorney;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface CardRepository extends CrudRepository<Card, Long> {
    public List<Card> findByPowerOfAttorneyAttorneyId(Long attorneyId);
   // public List<Card> findByStatus(String status);
    @Query("SELECT u FROM Card u WHERE u.status = 'active'")
    Collection<Card> findAllActiveUsers();
}
