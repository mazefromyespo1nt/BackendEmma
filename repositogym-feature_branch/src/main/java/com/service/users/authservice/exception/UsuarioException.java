package com.service.users.authservice.exception;

public class UsuarioException extends Exception {

    public UsuarioException(String message) {
        super(message);
    }
    public static class EmailNotFoundException extends RuntimeException {
        public EmailNotFoundException(String message) {
            super(message);
        }
    }

    public static class InvalidPasswordException extends RuntimeException {
        public InvalidPasswordException(String message) {
            super(message);
        }
    }

}
