package com.shehan.E_Commerce_Backend.repositories;

import com.shehan.E_Commerce_Backend.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}