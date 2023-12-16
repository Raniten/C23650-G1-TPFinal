package com.cac.C23650G1.mappers;

import com.cac.C23650G1.entities.Account;
import com.cac.C23650G1.entities.dtos.AccountDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountMapper {

    public AccountDto accountToDto(Account account){
        AccountDto dto = new AccountDto();

        dto.setId(account.getId());
        dto.setActive(account.isActive());
        dto.setType(account.getType());
        dto.setAccountNumber(account.getAccountNumber());
        dto.setCbu(account.getCbu());
        dto.setAlias(account.getAlias());
        dto.setAmount(account.getAmount());
        dto.setCreated_account(account.getCreated_account());
        dto.setUpdated_account(account.getUpdated_account());

        return dto;
    }

    public Account dtoToAccount(AccountDto dto){
        Account account = new Account();

        account.setId(dto.getId());
        account.setActive(dto.isActive());
        account.setType(dto.getType());
        account.setAccountNumber(dto.getAccountNumber());
        account.setCbu(dto.getCbu());
        account.setAlias(dto.getAlias());
        account.setAmount(dto.getAmount());
        account.setCreated_account(dto.getCreated_account());
        account.setUpdated_account(dto.getUpdated_account());

        return account;
    }
}
