package com.demos.paymybuddy.domain;

import com.demos.paymybuddy.utils.enums.Currency;
import com.demos.paymybuddy.utils.enums.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
@Data
@Entity
@Table(name = "account")
public class Account extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "account_number", nullable = false, unique = true)
    private String accountNumber;

    @Min(0)
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    @JoinColumn(name = "owner")
    private CustomUser owner;
}
