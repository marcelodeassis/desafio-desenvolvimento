package br.com.cresol.desafio.resources;

import br.com.cresol.desafio.dto.SimulacaoEntradaPayload;
import br.com.cresol.desafio.service.EmprestimoService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/simulacaoEmprestimo")
public class SimulacaoEmprestimoResource {

    private final EmprestimoService emprestimoService;

    public SimulacaoEmprestimoResource(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCliente(SimulacaoEntradaPayload payload) {
        return Response.ok(this.emprestimoService.persisteSimulacao(payload)).build();
    }
}