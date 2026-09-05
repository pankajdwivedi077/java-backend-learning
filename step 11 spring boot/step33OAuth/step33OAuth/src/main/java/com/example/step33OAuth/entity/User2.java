package com.example.step33OAuth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String provider;

    private String providerSubject;

    public User2( String name, String email, String provider,
                  String providerSubject) {
        this.name = name;
        this.email = email;
        this.provider = provider;
        this.providerSubject = providerSubject;
    }
}
