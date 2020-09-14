package com.rabobank.repository;

import com.rabobank.entity.Authorization;
import com.rabobank.entity.Card;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface AuthorizationRepository extends CrudRepository<Authorization, Long> {
    //public List<Authorization> findByPowerOfAttorneyAttorneyId(Long attorneyId);

   /* @Query("SELECT u FROM Card u WHERE u.status = 'active'")
    Collection<Card> findAllActiveCards();*/
}
