package com.shehan.E_Commerce_Backend.Services;

import com.shehan.E_Commerce_Backend.DTOs.UserDto;
import com.shehan.E_Commerce_Backend.entities.User;
import com.shehan.E_Commerce_Backend.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // Allowed fields for sorting
    private static final Set<String> ALLOWED_SORT_FIELDS =
            Set.of("id", "name", "email");

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
}