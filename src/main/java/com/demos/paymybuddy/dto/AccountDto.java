package com.demos.paymybuddy.dto;

import com.demos.paymybuddy.domain.CustomUser;
import com.demos.paymybuddy.utils.enums.Currency;
import com.demos.paymybuddy.utils.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data @NoArgsConstructor
@Builder @AllArgsConstructor
public class AccountDto {
    private Long accountNumber;
    private BigDecimal balance;
    private Currency currency;
    private Status status;
    private CustomUser owner;
}
