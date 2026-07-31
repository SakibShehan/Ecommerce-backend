package com.shehan.E_Commerce_Backend.DTOs;


import lombok.Data;

@Data
public class ChangePasswordDto {

    String oldPassword;
    String newPassword;
}
