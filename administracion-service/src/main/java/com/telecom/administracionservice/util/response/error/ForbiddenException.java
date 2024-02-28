package com.telecom.administracionservice.util.response.error;

public class ForbiddenException extends RuntimeException{

    private static final String DESCRIPCION = "Forbidden Exception (403)";

    public ForbiddenException(String message) {
        super(DESCRIPCION + ": " + message);
    }
}
