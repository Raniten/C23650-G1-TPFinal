package com.cac.C23650G1.services;

import com.cac.C23650G1.entities.Account;
import com.cac.C23650G1.entities.dtos.AccountDto;
import com.cac.C23650G1.entities.dtos.enums.AccountType;
import com.cac.C23650G1.mappers.AccountMapper;
import com.cac.C23650G1.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cac.C23650G1.exception.IllegalArgumentException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private final AccountRepository accountRepository;

    private AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountDto getAccountById(Long id) {
        Account acc = accountRepository.findById(id).get();
        return AccountMapper.accountToDto(acc);
    }

    public List<AccountDto> getAccounts() {
        return accountRepository.findAll().stream()
                .map(AccountMapper::accountToDto)
                .collect(Collectors.toList());
    }

    public AccountDto createAccount(AccountDto dto) {
        dto.setAmount(BigDecimal.ZERO);
        // TODO: REFACTOR para crear diferentes tipos de cuenta inicial
        dto.setType(AccountType.CAJA_AHORRO_PESOS);
        Account newAccount = AccountMapper.dtoToAccount(dto);
        return AccountMapper.accountToDto(accountRepository.save(newAccount));
    }


    public AccountDto inactiveAccount(Long id, AccountDto dto) {
        if (accountRepository.existsById(id)) {
            Account acc = accountRepository.findById(id).get();

            if (dto.isActive()) {
                acc.setActive(false);
            }

            return AccountMapper.accountToDto(acc);
        } else {
            return null;
        }
    }

    public AccountDto activeAccount(Long id, AccountDto dto) {
        if (accountRepository.existsById(id)) {
            Account acc = accountRepository.findById(id).get();

            if (!dto.isActive()) {
                acc.setActive(true);
            }

            return AccountMapper.accountToDto(acc);
        } else {
            return null;
        }
    }


    public AccountDto updateAccount(Long id, AccountDto dto) {
        if (accountRepository.existsById(id)) {
            Account acc = accountRepository.findById(id).get();

            if (dto.getAlias() != null) {
                acc.setAlias(dto.getAlias());
            }

            if (dto.getType() != null) {
                acc.setType(dto.getType());
            }

            if (dto.getCbu() != null) {
                acc.setCbu(dto.getCbu());
            }

            if (dto.getAmount() != null) {
                acc.setAmount(dto.getAmount());
            }

            return AccountMapper.accountToDto(acc);

        } else {
            return null;
        }
    }


    public String deleteAccount(Long id) {
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
            return "Cuenta eliminada";
        } else {
            return "No se pudo eliminar la cuenta";
        }
    }

    public String updateAlias(String id, String alias) {
        // NOTE: Ejemplo de excepción funcionando.
        if (alias == null || alias.isEmpty()) {
            throw new IllegalArgumentException("El alias no puede ser nulo o vacío");
        }
        return "updateAlias" + id + " " + alias;
    }


}
