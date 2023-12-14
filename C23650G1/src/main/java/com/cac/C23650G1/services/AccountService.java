package com.cac.C23650G1.services;

import com.cac.C23650G1.entities.Account;
import com.cac.C23650G1.entities.User;
import com.cac.C23650G1.entities.dtos.AccountDto;
import com.cac.C23650G1.mapper.AccountMapper;
import com.cac.C23650G1.mapper.UserMapper;
import com.cac.C23650G1.repository.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cac.C23650G1.exception.IllegalArgumentException;

import java.util.List;

@Service
public class AccountService {

  //inyeccion de dependencia de repositorio
  private AccountRepository repository;
  public AccountService(AccountRepository repository) {
    this.repository = repository;
  }

  public List<Account> getAccounts() {
    List<Account> acct = repository.findAll();
    return acct;
  }

  public AccountDto getAccountById(Long id) {
    Account acct = repository.findById(id).get();

    return AccountMapper.accountToDto(acct);
  }

  public AccountDto createAccount(AccountDto acct) {
    Account acctEntity = AccountMapper.dtoToAccount(acct);
    Account entitySaved = repository.save(acctEntity);
    acct = AccountMapper.accountToDto(entitySaved);

    return acct;
  }

  public AccountDto updateAccount(Long id, AccountDto dto) {
    if (repository.existsById(id)) {
      Account acctToModify = repository.findById(id).get();
      // Valdiar que datos no vienen en null para setearlos al objeto ya seteado

      if (dto.getType() != null) {
        acctToModify.setType(dto.getType());
      }
      if (dto.getAlias() != null) {
        acctToModify.setAlias(dto.getAlias());
      }
      if (dto.getCbu() != null) {
        acctToModify.setCbu(dto.getCbu());
      }
      if (dto.getAmount() != null) {
        acctToModify.setAmount(dto.getAmount());
      }
      if (dto.getUpdatedAm() != null) {
        acctToModify.setUpdatedAm(dto.getUpdatedAm());
      }
      if (dto.getCreatedAm() != null) {
        acctToModify.setCreatedAm(dto.getCreatedAm());
      }

      Account acctModified = repository.save(acctToModify);
      return AccountMapper.accountToDto(acctModified);
    } else return null;
  }

  public String deleteAccount(Long id) {
    if (repository.existsById(id)){
      repository.deleteById(id);
      return "La cuenta: " + id + " ha sido eliminada";
    }
    else return "La cuenta: " + id + " no ha sido eliminada";

  }

}
