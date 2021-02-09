package br.com.cresol.desafio.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Emprestimo> emprestimos;

    private String cpf;
    private String nome;
    private String email;
}
