package com.demos.paymybuddy.service.impl;

import com.demos.paymybuddy.domain.Account;
import com.demos.paymybuddy.domain.CustomUser;
import com.demos.paymybuddy.repository.AccountRepository;
import com.demos.paymybuddy.repository.CustomUserRepository;
import com.demos.paymybuddy.service.AccountService;
import com.demos.paymybuddy.utils.enums.Currency;
import com.demos.paymybuddy.utils.enums.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Optional<Account> findById(Long id) {
        return this.accountRepository.findById(id);
    }

    @Override
    public Account generateAccount() {

        Account newAccount = new Account();

        newAccount.setAccountNumber(this.generateAccountNumber());
        newAccount.setStatus(Status.ACTIVE);
        newAccount.setCurrency(Currency.Euro);
        newAccount.setBalance(BigDecimal.valueOf(0));
        newAccount.setCreatedAt(Instant.now());

        return this.accountRepository.save(newAccount);
    }


    private String generateAccountNumber() {
        int length = 10;
        String prefix = "ACCT";
        Random random = new Random();
        int randomNumber = random.nextInt(10000);

        return prefix + String.format("%0" + (length - prefix.length()) + "d", randomNumber);
    }

}
