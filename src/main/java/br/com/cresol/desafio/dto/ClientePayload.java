package br.com.cresol.desafio.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Getter
@Setter
public class ClientePayload {

    @CPF(message = "CPF precisa ser válido")
    private String cpf;

    @Size(min = 5, max = 200, message = "Nome precisa ter de 10 a 200 caracteres")
    private String nome;

    @Email(message = "Email precisa ser válido")
    private String email;
}
