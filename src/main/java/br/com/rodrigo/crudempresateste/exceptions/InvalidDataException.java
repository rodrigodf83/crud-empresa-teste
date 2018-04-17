package br.com.rodrigo.crudempresateste.exceptions;

public class InvalidDataException extends IllegalArgumentException {

    private String message;

    public InvalidDataException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
