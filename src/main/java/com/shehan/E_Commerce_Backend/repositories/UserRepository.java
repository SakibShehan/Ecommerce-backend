package com.shehan.E_Commerce_Backend.repositories;

import com.shehan.E_Commerce_Backend.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
