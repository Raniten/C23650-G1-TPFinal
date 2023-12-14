package com.cac.C23650G1.entities.dtos;

import com.cac.C23650G1.entities.enums.AccountType;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Long id;
    private AccountType type;
    private String cbu;
    private String alias;
    private BigDecimal amount;
    private LocalDateTime createdAm ;
    private LocalDateTime updatedAm;
}
