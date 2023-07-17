package br.com.banco.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Transferencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_transferencia")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dataTransferencia;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "tipo")
    private String tipoTransferencia;

    private String nomeOperadorTransacao;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;

    public Transferencia() {
    }

    public Transferencia(Long id, LocalDate dataTransferencia, BigDecimal valor, String tipoTransferencia, String nomeOperadorTransacao, Conta conta) {
        this.id = id;
        this.dataTransferencia = dataTransferencia;
        this.valor = valor;
        this.tipoTransferencia = tipoTransferencia;
        this.nomeOperadorTransacao = nomeOperadorTransacao;
        this.conta = conta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(LocalDate dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getTipoTransferencia() {
        return tipoTransferencia;
    }

    public void setTipoTransferencia(String tipoTransferencia) {
        this.tipoTransferencia = tipoTransferencia;
    }

    public String getNomeOperadorTransacao() {
        return nomeOperadorTransacao;
    }

    public void setNomeOperadorTransacao(String nomeOperadorTransacao) {
        this.nomeOperadorTransacao = nomeOperadorTransacao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Transferencia{");
        sb.append("id=").append(id);
        sb.append(", dataTransferencia=").append(dataTransferencia);
        sb.append(", valor=").append(valor);
        sb.append(", tipoTransferencia='").append(tipoTransferencia).append('\'');
        sb.append(", nomeOperadorTransacao='").append(nomeOperadorTransacao).append('\'');
        sb.append(", conta=").append(conta);
        sb.append('}');
        return sb.toString();
    }
}
