package com.demos.paymybuddy.service;

import com.demos.paymybuddy.domain.CustomUser;
import com.demos.paymybuddy.dto.CustomUserDto;

import java.util.Optional;

public interface CustomUserService {
    Optional<CustomUser> findById(Long id);
    CustomUser findByUsername(String username);
    CustomUserDto getCustomUserDtoByUsername(String username);
    CustomUserDto getCustomUserDtoByEmail(String email);
    CustomUser findByEmail(String email);
    void save(CustomUserDto userDto);
    void deleteFromFriendsList(String userEmail,String friendEmail);
    void addToFriendsList(String userEmail,String friendEmail);
}
