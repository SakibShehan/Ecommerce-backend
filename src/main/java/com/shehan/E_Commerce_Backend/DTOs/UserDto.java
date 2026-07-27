package com.shehan.E_Commerce_Backend.DTOs;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDto {
     Long id;
     String name;
     String email;
}
