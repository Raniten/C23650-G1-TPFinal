package com.cac.C23650G1.mapper;

import com.cac.C23650G1.entities.Account;
import com.cac.C23650G1.entities.User;
import com.cac.C23650G1.entities.dtos.AccountDto;
import com.cac.C23650G1.entities.dtos.UserDto;

import java.time.LocalDateTime;

public class AccountMapper {

    //transforma un AccountDto en un Account
    public static Account dtoToAccount(AccountDto dto){
        Account act = new Account();
        act.setType(dto.getType());
        act.setCbu(dto.getCbu());
        act.setAlias(dto.getAlias());
        act.setAmount(dto.getAmount());
        act.setCreatedAm(dto.getCreatedAm());
        act.setUpdatedAm(dto.getUpdatedAm());

        return act;
    }

    public static AccountDto accountToDto(Account act){
        AccountDto dto = new AccountDto();
        dto.setType(act.getType());
        dto.setCbu(act.getCbu());
        dto.setAlias(act.getAlias());
        dto.setAmount(act.getAmount());
        dto.setCreatedAm(act.getCreatedAm());
        dto.setUpdatedAm(act.getUpdatedAm());

        return dto;
    }
}
