package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class House {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "human_fk", nullable = false, updatable = false)
    private Human human;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_fk", nullable = false, updatable = false)
    private Address address;
}
