package br.com.cresol.desafio.model;

import br.com.cresol.desafio.dto.ClientePayload;
import br.com.cresol.desafio.dto.SimulacaoPayload;

public class EmprestimoMapper {
    public static SimulacaoPayload convertToDto(Emprestimo e) {
        return SimulacaoPayload.builder()
                .dataSimulacao(e.getDataSimulacao())
                .numeroContrato(e.getNumeroContrato())
                .quantidadeParcelas(e.getQuantidadeParcelas())
                .taxaJuros(e.getTaxaJuros())
                .valorContrato(e.getValorContrato())
                .build();
    }
}
