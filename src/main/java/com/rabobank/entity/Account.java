package com.rabobank.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountHolderName;
    private String balance;
    private String createDate;
    private String endDate;

    @ManyToOne
    private PowerOfAttorney powerOfAttorney;
    public Account() {
    }

    public Account(Long id, String accountHolderName, String balance, String createDate, String endDate, PowerOfAttorney powerOfAttorney) {
        this.id = id;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.createDate = createDate;
        this.endDate = endDate;
        this.powerOfAttorney = powerOfAttorney;
    }
}
