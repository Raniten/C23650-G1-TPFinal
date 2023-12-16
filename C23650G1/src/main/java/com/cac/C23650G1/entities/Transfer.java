package com.cac.C23650G1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="transfers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransfer;

    //@Column(name = "account_number")
    //private String accountNumber;

    @Column(name = "id_account_sender")
    private Long idAccountSender;

    @Column(name = "id_account_recipient")
    private Long idAccountRecipient;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "amount")
    private BigDecimal amount;


}
