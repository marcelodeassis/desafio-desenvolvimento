package br.com.cresol.desafio.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private String errorMessage;

    public ErrorResponse(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }

    public ErrorResponse() {}
}
