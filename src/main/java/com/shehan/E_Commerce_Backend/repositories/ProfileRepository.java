package com.shehan.E_Commerce_Backend.repositories;

import com.shehan.E_Commerce_Backend.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}