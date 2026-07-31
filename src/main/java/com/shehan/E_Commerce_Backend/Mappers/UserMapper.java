package com.shehan.E_Commerce_Backend.Mappers;

import com.shehan.E_Commerce_Backend.DTOs.RegisterUserDto;
import com.shehan.E_Commerce_Backend.DTOs.UpdateUserDto;
import com.shehan.E_Commerce_Backend.DTOs.UserDto;
import com.shehan.E_Commerce_Backend.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // Entity -> Response DTO
    UserDto toDto(User user);

    // Register Request DTO -> Entity
     User toEntity(RegisterUserDto registerUserDto);

     void Update(UpdateUserDto request,@MappingTarget User user);
}