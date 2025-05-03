package com.app.Model;

import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * JPA Entity intended to model a grocery item such as Milk, Bread, etc.
 *
 * For the sake of brevity, Lombok is also used to automatically generate boilerplate code.
 */
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Grocery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public Grocery(String name) {
        this.name = name;
    }
}