package com.pragma.powerup.infrastructure.exceptionhandler;

public enum ExceptionResponse {
    ERROR_SENDING_SMS("No se logro enviar el SMS");

    private final String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}