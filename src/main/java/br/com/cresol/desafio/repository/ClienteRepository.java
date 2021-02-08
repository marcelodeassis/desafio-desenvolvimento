package br.com.cresol.desafio.repository;

import br.com.cresol.desafio.model.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {

    public boolean isCpfUsado(String cpf){
        return count("cpf",cpf) > 0;
    }

}
