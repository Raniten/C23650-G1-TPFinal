package com.cac.C23650G1.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cac.C23650G1.services.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

  private final UserService userService;

  @GetMapping
  public ResponseEntity<?> getAccounts() {
    return "Accounts";
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getAccount(HttpServletRequest request) {
    String id = request.getParameter("id");
    return ResponseEntity.ok().body(userService.getUser(id));
  }

  @PostMapping
  public ResponseEntity<?> createAccount() {
    return ResponseEntity.ok().body("Account created");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> disableAccount() {
    return ResponseEntity.ok().body("Account disabled");
  }

}
