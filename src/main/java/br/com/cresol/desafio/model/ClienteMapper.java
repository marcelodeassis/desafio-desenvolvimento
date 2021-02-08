package br.com.cresol.desafio.model;

import br.com.cresol.desafio.dto.ClienteDTO;

public class ClienteMapper {
    public static Cliente convertToModel(ClienteDTO p) {
        Cliente c = new Cliente();
        c.setCpf(p.getCpf());
        c.setEmail(p.getEmail());
        c.setNome(p.getNome());
        return c;
    }
}
