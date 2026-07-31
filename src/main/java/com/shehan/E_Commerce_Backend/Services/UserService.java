package com.shehan.E_Commerce_Backend.Services;

import com.shehan.E_Commerce_Backend.DTOs.ChangePasswordDto;
import com.shehan.E_Commerce_Backend.DTOs.UpdateUserDto;
import com.shehan.E_Commerce_Backend.DTOs.UserDto;
import com.shehan.E_Commerce_Backend.Mappers.ProductMapper;
import com.shehan.E_Commerce_Backend.Mappers.UserMapper;
import com.shehan.E_Commerce_Backend.entities.User;
import com.shehan.E_Commerce_Backend.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;
    
    private final ProductMapper productMapper;

    // Allowed fields for sorting
    private static final Set<String> ALLOWED_SORT_FIELDS =
            Set.of("id", "name", "email");



    public UserDto createUser(User user) {

        User savedUser = userRepository.save(user);

        return userMapper.toDto(savedUser);
    }




    public List<UserDto> findAllUsers(String sort) {

        if (!ALLOWED_SORT_FIELDS.contains(sort)) {
            throw new IllegalArgumentException(
                    "Invalid sort field. Allowed values are: id, name, email");
        }

        return userRepository.findAll(Sort.by(sort))
                .stream()
                .map(user -> new UserDto(
                        user.getId(),
                        user.getName(),
                        user.getEmail()))
                .toList();
    }

    public UserDto findUserById(Long id) {
        return userRepository.findById(id)
                .map(user -> new UserDto(
                        user.getId(),
                        user.getName(),
                        user.getEmail()))
                .orElse(null);
    }

    public ResponseEntity<UserDto> UpdateUser(Long id, UpdateUserDto request) {

        var User= userRepository.findById(id).orElse(null);

        if(User== null) return ResponseEntity.notFound().build();

//        User.setName(request.getName());
//        User.setEmail(request.getEmail());

        userMapper.Update(request, User);
        userRepository.save(User);

        return ResponseEntity.ok(userMapper.toDto(User));

    }

    public <T> ResponseEntity<T> DeleteUser(Long id) {

        var user= userRepository.findById(id).orElse(null);

        if (user==null)
        {
            return ResponseEntity.notFound().build();
        }

        userRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Void> ChangePassword(Long id, ChangePasswordDto changePasswordDto) {

        var user= userRepository.findById(id).orElse(null);

        if (user==null)
        {
            return ResponseEntity.notFound().build();
        }

        if(!user.getPassword().equals(changePasswordDto.getOldPassword()))
        {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        user.setPassword(changePasswordDto.getNewPassword());
        userRepository.save(user);

        return ResponseEntity.noContent().build();
    }
}