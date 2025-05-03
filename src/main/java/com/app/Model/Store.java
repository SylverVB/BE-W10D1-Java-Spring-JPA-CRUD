package com.app.Model;

import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * JPA Entity intended to model a grocery store.
 *
 * For the sake of brevity, Lombok is also used to automatically generate boilerplate code.
 */
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;

    public Store(String name, String address) {
        this.name = name;
        this.address = address;
    }
}