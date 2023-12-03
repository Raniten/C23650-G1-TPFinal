package com.cac.C23650G1.services;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
public class AccountService {

  public String getUsers() {
    return "getUsers";
  }

  public String getUser(String id) {
    return "getUser" + id;
  }

  public String createUser() {
    return "createUser";
  }

  public String updateAlias(String id, String alias) {
    return "updateAlias" + id + " " + alias;
  }

  public String disableUser() {
    return "disableUser";
  }

}
