package com.app.Repository;

import com.app.Model.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryRepository extends JpaRepository<Grocery, Long> {
}