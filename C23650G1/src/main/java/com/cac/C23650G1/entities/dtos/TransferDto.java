package com.cac.C23650G1.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferDto {
    private Long idTransfer;
    private Long idAccountSender;
    private Long idAccountRecipient;
    private LocalDate date;
    private BigDecimal amount;

}
