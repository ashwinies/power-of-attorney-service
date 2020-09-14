package com.rabobank.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


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
   /* private List<Authorization> authorizationList;*/



    public PowerOfAttorney() {
    }



    public PowerOfAttorney(Long attorneyId, String grantor, String grantee, String account, String direction) {
        super();
        this.attorneyId = attorneyId;
        this.grantor = grantor;
        this.grantee = grantee;
        this.account = account;
        this.direction = direction;
        /*this.authorizationList = authorizationList;
        this.cards = cards;*/
    }

  /*  public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGrantor() {
        return grantor;
    }

    public void setGrantor(String grantor) {
        this.grantor = grantor;
    }

    public String getGrantee() {
        return grantee;
    }

    public void setGrantee(String grantee) {
        this.grantee = grantee;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }*/

    @Override
    public String toString() {
        return "PowerOfAttorney{" +
                "attorneyId=" + attorneyId +
                ", grantor='" + grantor + '\'' +
                ", grantee='" + grantee + '\'' +
                ", account='" + account + '\'' +
                ", direction='" + direction + '\'' +
                '}';
    }
}
