package com.shehan.E_Commerce_Backend.DTOs;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class RegisterUserDto {
    private String name;
    private String email;
    private String password;
}
