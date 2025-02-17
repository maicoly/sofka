package com.test.sofka.AccountMovements.exception;

import java.io.Serializable;

/**
 * Esta clase define una excepción personalizada con el objetivo de que cuando se cree una nueva excepción, sea manejada
 * por la clase CustomExceptionHandler y se genere un Response el cual será devuelto en el endpoint
 */
public class CustomException extends RuntimeException implements Serializable {
    private String descError;
    private static final long serialVersionUID = 1L;

    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, String descError) {
        super(message);
        this.descError = descError;
    }

    public String getDescError() {
        return descError;
    }
}
