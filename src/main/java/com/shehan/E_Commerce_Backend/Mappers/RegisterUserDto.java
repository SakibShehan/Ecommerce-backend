package com.shehan.E_Commerce_Backend.Mappers;

import com.shehan.E_Commerce_Backend.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegisterUserDto {

    User toEntity (RegisterUserDto registerUserDto);
}
