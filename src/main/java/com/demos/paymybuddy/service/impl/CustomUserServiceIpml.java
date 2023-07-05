package com.demos.paymybuddy.service.impl;

import com.demos.paymybuddy.domain.Account;
import com.demos.paymybuddy.domain.CustomUser;
import com.demos.paymybuddy.dto.CustomUserDto;
import com.demos.paymybuddy.mapper.CustomUserMapper;
import com.demos.paymybuddy.repository.CustomUserRepository;
import com.demos.paymybuddy.service.AccountService;
import com.demos.paymybuddy.service.CustomUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserServiceIpml implements CustomUserService {

    private final CustomUserRepository userRepository;
    private final AccountService accountService;
    private final CustomUserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<CustomUser> findById(Long id) {
        return this.userRepository.findById(id);
    }

    @Override
    public CustomUser findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public CustomUserDto getCustomUserDtoByUsername(String username) {
        return this.userMapper.customUserToCustomUserDto(this.userRepository.findByUsername(username));
    }
    @Override
    public CustomUserDto getCustomUserDtoByEmail(String email) {
        return this.userMapper.customUserToCustomUserDto(this.userRepository.findByEmail(email));
    }
    @Override
    public CustomUser findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }
    @Override
    public void save(CustomUserDto userDto) {
        CustomUser user = this.userMapper.customUserDtoToCustomUser(userDto);
        user.setPassword(this.passwordEncoder.encode(userDto.getPassword()));
        Account account = this.accountService.generateAccount();
        user.setAccount(account);

        this.userRepository.save(user);
    }
    @Override
    public void deleteFromFriendsList(String userEmail,String friendEmail) {
        CustomUser user = this.userRepository.findByEmail(userEmail);
        user.getFriendsList().remove(this.userRepository.findByEmail(friendEmail));
        this.userRepository.save(user);
    }
    @Override
    public void addToFriendsList(String userEmail, String friendEmail) {
        CustomUser user = this.userRepository.findByEmail(userEmail);
        user.getFriendsList().add(this.userRepository.findByEmail(friendEmail));
        this.userRepository.save(user);
    }
}
