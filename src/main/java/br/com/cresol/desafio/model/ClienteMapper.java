package br.com.cresol.desafio.model;

import br.com.cresol.desafio.dto.ClientePayload;

public class ClienteMapper {
    public static Cliente convertToModel(ClientePayload p) {
        Cliente c = new Cliente();
        c.setCpf(p.getCpf());
        c.setEmail(p.getEmail());
        c.setNome(p.getNome());
        return c;
    }
}
