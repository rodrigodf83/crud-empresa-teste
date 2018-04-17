package br.com.rodrigo.crudempresateste.exceptions;

public class ErrorExecutionException extends RuntimeException {

    private String message;

    public ErrorExecutionException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
