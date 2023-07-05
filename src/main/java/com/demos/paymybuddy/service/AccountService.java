package com.demos.paymybuddy.service;

import com.demos.paymybuddy.domain.Account;
import com.demos.paymybuddy.domain.CustomUser;

import java.util.Optional;

public interface AccountService {
    Optional<Account> findById(Long id);

    Account generateAccount();
}
