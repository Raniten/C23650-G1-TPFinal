package com.cac.C23650G1.security.payload;

import lombok.Data;

@Data
public class ErrorResponse {

  private String error;
  private String message;

  public ErrorResponse(String error, String message) {
    this.error = error;
    this.message = message;
  }

}
