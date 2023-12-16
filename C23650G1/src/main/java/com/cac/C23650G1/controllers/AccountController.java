package com.cac.C23650G1.controllers;

<<<<<<< HEAD
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cac.C23650G1.services.AccountService;
=======
import com.cac.C23650G1.entities.dtos.AccountDto;
import com.cac.C23650G1.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
>>>>>>> Fernando

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

<<<<<<< HEAD
  private final AccountService accountService;

  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @GetMapping
  public ResponseEntity<?> getAccounts() {
    return ResponseEntity.ok().body(accountService.getUsers());
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getAccount(@PathVariable String id) {
    return ResponseEntity.ok().body(accountService.getUser(id));
  }

  @PostMapping
  public ResponseEntity<?> createAccount() {
    return ResponseEntity.ok().body(accountService.createUser());
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateAlias(@PathVariable String id, @RequestBody Map<String, String> body) {
    String alias = body.get("alias");
    return ResponseEntity.ok().body(accountService.updateAlias(id, alias));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> disableAccount() {
    return ResponseEntity.ok().body(accountService.disableUser());
  }

}
=======
    private final AccountService service;

    private AccountController(AccountService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAccounts(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAccounts());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAccountById(id));
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto account){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createAccount(account));
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable Long id, @RequestBody AccountDto account){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateAccount(id, account));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteAccount(id));
    }

}

>>>>>>> Fernando
