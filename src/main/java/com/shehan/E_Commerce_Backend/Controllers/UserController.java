package com.shehan.E_Commerce_Backend.Controllers;


import com.shehan.E_Commerce_Backend.Services.UserService;
import com.shehan.E_Commerce_Backend.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    UserService userServices;

    @GetMapping("/users")
    public Iterable<User> getAllUsers() {

        return userServices.findAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById (@PathVariable Long id) {

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
