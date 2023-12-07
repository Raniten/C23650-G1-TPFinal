package com.cac.C23650G1.services;

import org.springframework.stereotype.Service;

import com.cac.C23650G1.exception.IllegalArgumentException;

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
    // NOTE: Ejemplo de excepción funcionando.
    if (alias == null || alias.isEmpty()) {
      throw new IllegalArgumentException("El alias no puede ser nulo o vacío");
    }
    return "updateAlias" + id + " " + alias;
  }

  public String disableUser() {
    return "disableUser";
  }

}
