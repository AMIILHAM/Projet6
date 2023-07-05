package com.demos.paymybuddy.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Entity @Data
@Table(name = "transaction")
public class Transaction extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @NotNull
    @Column(name = "fee", nullable = false)
    private BigDecimal fee;

    @OneToOne
    @JoinColumn(name = "source_account_id")
    private Account source;

    @OneToOne
    @JoinColumn(name = "destination_account_id")
    private Account destination;
}
