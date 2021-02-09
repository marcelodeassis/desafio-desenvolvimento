package br.com.cresol.desafio.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class SimulacaoEntradaPayload {
    private ClientePayload cliente;

    @Range(min = 100, max = Long.MAX_VALUE, message = "Valor do contrato precisa ser maior que 100")
    private BigDecimal valorContrato;

    @Range(min = 1, max = 24, message = "Número de parcelas precisa estar entre 1 e 24")
    private Integer quantidadeParcelas;
}
