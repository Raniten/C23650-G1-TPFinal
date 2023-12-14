package com.cac.C23650G1.entities.dtos;

import com.cac.C23650G1.entities.Account;
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
public class TransferDto {
    private Long id;
    private BigDecimal amount;
    private Account originAccount;
    private Account destinyAccount;
    private LocalDateTime dateTransfer;
}
