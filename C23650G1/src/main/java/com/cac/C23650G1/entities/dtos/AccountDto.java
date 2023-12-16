package com.cac.C23650G1.entities.dtos;

import com.cac.C23650G1.entities.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    private Long idAccount;
    private AccountType type;
    private boolean active;
    private String accountNumber;
    private String cbu;
    private String alias;
    private BigDecimal amount;
    private LocalDateTime created_account;
    private LocalDateTime updated_account;
    private Long idUser;

}
