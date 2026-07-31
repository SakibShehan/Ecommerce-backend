package com.shehan.E_Commerce_Backend.Controllers;


import com.shehan.E_Commerce_Backend.DTOs.RegisterUserDto;
import com.shehan.E_Commerce_Backend.DTOs.UpdateUserDto;
import com.shehan.E_Commerce_Backend.DTOs.UserDto;
import com.shehan.E_Commerce_Backend.Mappers.UserMapper;
import com.shehan.E_Commerce_Backend.Services.UserService;
import com.shehan.E_Commerce_Backend.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@AllArgsConstructor
public class UserController {

    UserService userServices;
    private final UserMapper userMapper;

    @GetMapping("/users")
    public Iterable<UserDto> getAllUsers(@RequestParam (defaultValue = "id") String sort) {

        return userServices.findAllUsers(sort);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUserById (@PathVariable Long id) {

        var user= userServices.findUserById(id);

        if(user==null){
            return ResponseEntity.status(404).body(null);
        }
        else
           {
            return ResponseEntity.ok(user);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(
            @RequestBody RegisterUserDto request,
            UriComponentsBuilder uriBuilder) {

        User user = userMapper.toEntity(request);

        UserDto userDto = userServices.createUser(user);

        URI uri = uriBuilder
                .path("/users/{id}")
                .buildAndExpand(userDto.getId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(userDto);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserDto> UpdateUser (
            @PathVariable( name ="id") Long id,
            @RequestBody UpdateUserDto updateUserDto
            )
    {
              return userServices.UpdateUser(id, updateUserDto);
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<Void> DeleteUser( @PathVariable Long id)
    {

        return userServices.DeleteUser(id);
    }


}
