package com.siri.EcomUserAuthService.exception;

public class RoleNotFoundExceptiom extends RuntimeException{
    public RoleNotFoundExceptiom() {

    }

    public RoleNotFoundExceptiom(String message) {
        super(message);
    }

    public RoleNotFoundExceptiom(String message, Throwable cause) {
        super(message, cause);
    }
}
