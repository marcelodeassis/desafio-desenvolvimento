package br.com.cresol.desafio.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionHandler implements ExceptionMapper<GenericException> {
    @Override
    public Response toResponse(GenericException e)
    {
        ErrorResponse er = new ErrorResponse(e.getMessage());
        return Response.status(400).entity(er).build();
    }
}
