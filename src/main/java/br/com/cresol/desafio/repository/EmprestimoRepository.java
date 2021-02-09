package br.com.cresol.desafio.repository;

import br.com.cresol.desafio.model.Emprestimo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmprestimoRepository implements PanacheRepository<Emprestimo> {
}
