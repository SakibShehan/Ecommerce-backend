package com.shehan.E_Commerce_Backend.Controllers;


import com.shehan.E_Commerce_Backend.DTOs.UserDto;
import com.shehan.E_Commerce_Backend.Services.UserService;
import com.shehan.E_Commerce_Backend.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    UserService userServices;

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
}
