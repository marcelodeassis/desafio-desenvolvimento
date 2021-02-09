package br.com.cresol.desafio.service;

import br.com.cresol.desafio.dto.SimulacaoEntradaPayload;
import br.com.cresol.desafio.dto.SimulacaoPayload;
import br.com.cresol.desafio.exception.GenericException;
import br.com.cresol.desafio.model.*;
import br.com.cresol.desafio.repository.EmprestimoRepository;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@ApplicationScoped
public class EmprestimoService {

    @Inject
    EmprestimoRepository emprestimoRepository;
    @Inject
    ClienteService clienteService;
    @Inject
    Validator validator;


    @Transactional
    public SimulacaoPayload persisteSimulacao(SimulacaoEntradaPayload simPayload) {
        log.info(simPayload.toString());

        Set<ConstraintViolation<SimulacaoEntradaPayload>> validacoes = validator.validate(simPayload);
        List<String> errorMsgs = validacoes.stream().map(cv -> cv.getMessage()).collect(Collectors.toList());
        if(errorMsgs.size() > 0){
            throw new GenericException(errorMsgs.toString());
        }

        Cliente cliente = clienteService.persistSeNaoExiste(simPayload.getCliente());

        Emprestimo emprestimo = geraEmprestimo(simPayload);
        emprestimo.setCliente(cliente);

        emprestimoRepository.persist(emprestimo);
        return EmprestimoMapper.convertToDto(emprestimo);
    }

    private Emprestimo geraEmprestimo(SimulacaoEntradaPayload simPayload){
        Cliente c = ClienteMapper.convertToModel(simPayload.getCliente());
        RegrasEmprestimo regras = new RegrasEmprestimo(simPayload);

        return Emprestimo.builder()
                .cliente(c)
                .quantidadeParcelas(simPayload.getQuantidadeParcelas())
                .valorContrato(simPayload.getValorContrato())
                .taxaJuros(regras.getTaxaJuros())
                .valorParcelas(regras.getValorParcelas())
                .build();
    }
}
