package com.cac.C23650G1.exception;

public class IllegalArgumentException extends RuntimeException {
  // NOTE: utilizar esta excepción cuando se intente crear un recurso con datos
  // inválidos, por ejemplo, un usuario con un email inválido.
  public IllegalArgumentException(String message) {
    super(message);
  }

}