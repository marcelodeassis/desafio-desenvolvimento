package br.com.cresol.desafio.resources;

import br.com.cresol.desafio.dto.ClienteDTO;
import br.com.cresol.desafio.model.Cliente;
import br.com.cresol.desafio.service.ClienteService;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/cliente")
public class ClienteResource {

    private final ClienteService clienteService;

    public ClienteResource(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente getCliente(@PathParam Long id) {
        return clienteService.getClienteById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> getAllClientes() {
        return clienteService.listAll() ;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCliente(ClienteDTO payload) {
        clienteService.persistCliente(payload);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCliente(@PathParam Long id, ClienteDTO payload) {
        clienteService.persistCliente(payload, id);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCliente(@PathParam Long id) {
        clienteService.deleteCliente(id);
        return Response.ok().build();
    }
}