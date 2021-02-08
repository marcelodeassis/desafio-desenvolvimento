package br.com.cresol.desafio.exception;

public class GenericException extends RuntimeException {

    public GenericException(String message) {
        super(message);
    }

    public GenericException(String message, Throwable err) {
        super(message, err);
    }
}
