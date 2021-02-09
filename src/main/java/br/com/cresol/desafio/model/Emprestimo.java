package br.com.cresol.desafio.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@Setter
@Builder
public class Emprestimo {
    @Id
    @GeneratedValue(generator = "contrato-generator")
    @GenericGenerator(name = "contrato-generator", strategy = "br.com.cresol.desafio.model.NumeroContratoGenerator")
    private String numeroContrato;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;

    @Column(nullable = false)
    private BigDecimal valorContrato;

    @Column(nullable = false)
    private BigDecimal valorParcelas;

    @Column(nullable = false)
    private BigDecimal taxaJuros;

    @Column(nullable = false)
    private Integer quantidadeParcelas;

    @Column(nullable = false)
    private LocalDateTime dataSimulacao;

    @Column(nullable = true)
    private LocalDateTime dataContrato;

    public Emprestimo() {
        dataSimulacao = LocalDateTime.now();
    }

    public Emprestimo(String numeroContrato, Cliente cliente, BigDecimal valorContrato, BigDecimal valorParcelas,
                      BigDecimal taxaJuros, Integer quantidadeParcelas, LocalDateTime dataSimulacao, LocalDateTime dataContrato) {
        this.numeroContrato = numeroContrato;
        this.cliente = cliente;
        this.valorContrato = valorContrato;
        this.valorParcelas = valorParcelas;
        this.taxaJuros = taxaJuros;
        this.quantidadeParcelas = quantidadeParcelas;
        this.dataSimulacao = LocalDateTime.now();
        this.dataContrato = null;
    }
}
