package com.demos.paymybuddy.dto;

import com.demos.paymybuddy.domain.Account;
import com.demos.paymybuddy.domain.CustomUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @NoArgsConstructor
@Builder @AllArgsConstructor
public class CustomUserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;
    private String username;
    private String password;
    private Account account;
    private List<CustomUser> friendsList;
}
