package com.cac.C23650G1.exception;

public class DataIntegrityViolationException extends RuntimeException {
  // NOTE: utilizar esta excepción cuando se intente crear un recurso que ya
  // existe, por ejemplo, un usuario con un email que ya existe en la base de
  // datos.
  public DataIntegrityViolationException(String message) {
    super(message);
  }

}