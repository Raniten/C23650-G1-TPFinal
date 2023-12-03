package com.cac.C23650G1.exception;

public class ResourceNotFoundException extends RuntimeException {
  // NOTE: utilizar esta excepción cuando se intente acceder a un recurso que no
  // existe, por ejemplo, un usuario con un id que no existe en la base de datos.
  public ResourceNotFoundException(String message) {
    super(message);
  }

}