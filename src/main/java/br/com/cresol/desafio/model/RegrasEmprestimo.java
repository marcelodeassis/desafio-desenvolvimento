package br.com.cresol.desafio.model;

import br.com.cresol.desafio.dto.SimulacaoEntradaPayload;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
public class RegrasEmprestimo {
    private BigDecimal taxaJuros;
    private BigDecimal valorParcelas;

    public RegrasEmprestimo(SimulacaoEntradaPayload payload) {
        taxaJuros = payload.getValorContrato().compareTo(BigDecimal.valueOf(1000)) <= 0 ? BigDecimal.valueOf(0.18) : BigDecimal.valueOf(0.3);
        if(payload.getQuantidadeParcelas() > 12){
            taxaJuros.add(BigDecimal.valueOf(0.05));
        }

        valorParcelas = payload.getValorContrato()
                .multiply(
                        BigDecimal.valueOf(1).add(
                                BigDecimal.valueOf(payload.getQuantidadeParcelas()).multiply(taxaJuros)
                        )
                )
                .divide( BigDecimal.valueOf(payload.getQuantidadeParcelas()) , RoundingMode.UP);
    }
}
