package com.cac.C23650G1.controllers;

import java.util.Map;

import com.cac.C23650G1.entities.dtos.AccountDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cac.C23650G1.services.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

  private final AccountService accountService;
  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @GetMapping
  public ResponseEntity<?> getAccounts() {
    return ResponseEntity.ok().body(accountService.getAccounts());
  }

  @GetMapping("/{id}")
  public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
    return ResponseEntity.status(HttpStatus.OK).body(accountService.getAccountById(id));
  }

  @PostMapping
  public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto dto){
    return ResponseEntity.status(HttpStatus.CREATED).body(accountService.createAccount(dto));
  }

  @PutMapping("/{id}")
  public ResponseEntity<AccountDto> updateAccount(@PathVariable Long id,
                                         @RequestBody AccountDto dto){
    return ResponseEntity.status(HttpStatus.OK).body(accountService.updateAccount(id,dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> disableAccount(@PathVariable Long id) {
    return ResponseEntity.ok().body(accountService.deleteAccount(id));
  }

}
