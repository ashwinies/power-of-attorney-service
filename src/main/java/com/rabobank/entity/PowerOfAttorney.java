package com.rabobank.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Setter
@Getter

public class PowerOfAttorney {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attorneyId;
    private String grantor;
    private String grantee;
    private String account;
    private String direction;
    @ManyToMany
    private Set<Authorization> authorizationSet = new HashSet<>();


    public PowerOfAttorney() {
    }


    public PowerOfAttorney(Long attorneyId, String grantor, String grantee, String account, String direction) {
        super();
        this.attorneyId = attorneyId;
        this.grantor = grantor;
        this.grantee = grantee;
        this.account = account;
        this.direction = direction;
        this.authorizationSet = authorizationSet;
    }


   /* @Override
    public String toString() {
        return "PowerOfAttorney{" +
                "attorneyId=" + attorneyId +
                ", grantor='" + grantor + '\'' +
                ", grantee='" + grantee + '\'' +
                ", account='" + account + '\'' +
                ", direction='" + direction + '\'' +
                '}';
    }*/
}
