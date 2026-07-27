package com.shehan.E_Commerce_Backend.repositories;

import com.shehan.E_Commerce_Backend.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}