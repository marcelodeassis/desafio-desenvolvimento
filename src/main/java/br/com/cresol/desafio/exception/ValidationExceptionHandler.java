package br.com.cresol.desafio.exception;

import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ValidationExceptionHandler implements ExceptionMapper<ValidationException> {
    @Override
    public Response toResponse(ValidationException exception)
    {
        ErrorResponse er = new ErrorResponse(exception.getMessage());
        return Response.status(400).entity(er).build();
    }
}
