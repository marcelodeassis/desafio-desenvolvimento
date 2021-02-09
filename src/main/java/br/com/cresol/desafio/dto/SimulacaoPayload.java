package br.com.cresol.desafio.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString
@Builder
public class SimulacaoPayload {
    private String numeroContrato;
    private LocalDateTime dataSimulacao;
    private LocalDateTime validadeSimulacao;
    private BigDecimal valorContrato;
    private Integer quantidadeParcelas;
    private BigDecimal taxaJuros;

    public String getValidadeSimulacao(){
        return dataSimulacao.plusDays(30).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    public String getDataSimulacao(){
        return dataSimulacao.plusDays(30).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }
}
