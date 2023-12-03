package com.cac.C23650G1.controllers;

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

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

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
