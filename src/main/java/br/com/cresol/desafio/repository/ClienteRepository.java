package br.com.cresol.desafio.repository;

import br.com.cresol.desafio.model.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {

    public boolean isCpfUsado(String cpf){
        return count("cpf",cpf) > 0;
    }

    public Optional<Cliente> findByCpfOptional(String cpf){
        Cliente c = find("cpf", cpf).firstResult();
        return Optional.ofNullable(c);
    }

}
