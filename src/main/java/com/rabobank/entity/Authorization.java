package com.rabobank.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class Authorization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    @ManyToMany
    private Set<PowerOfAttorney> attorneys = new HashSet<>();

    public Authorization() {
    }

    public Authorization(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public Authorization(Long id, String type, Set<PowerOfAttorney> attorneys) {
        this.id = id;
        this.type = type;
        this.attorneys = attorneys;
    }

    public Authorization(String authorizationType) {
        this.type=authorizationType;
    }
}
