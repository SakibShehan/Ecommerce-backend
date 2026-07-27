package com.shehan.E_Commerce_Backend.repositories;

import com.shehan.E_Commerce_Backend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}