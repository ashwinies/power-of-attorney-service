package com.rabobank.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;
    private String type;
    private String status;
    private String cardHolder;

    @ManyToOne
    private PowerOfAttorney powerOfAttorney;

    public Card() {
    }

    public Card(Long cardId, String type, String status, String cardHolder, Long powerOfAttorney) {
        super();
        this.cardId = cardId;
        this.type = type;
        this.status = status;
        this.cardHolder = cardHolder;
        this.powerOfAttorney = new PowerOfAttorney(powerOfAttorney, "", "", "", "");
    }

}
