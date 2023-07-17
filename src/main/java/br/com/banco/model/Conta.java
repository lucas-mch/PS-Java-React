package br.com.banco.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Conta  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_conta")
    private long id;

    @Column(name="nome_responsavel")
    private String nomeResponsavel;

    @JsonIgnore
    @OneToMany(mappedBy = "conta")
    private List<Transferencia> transferencias = new ArrayList<>();

    public Conta() {
    }

    public Conta(long id, String nomeResponsavel) {
        this.id = id;
        this.nomeResponsavel = nomeResponsavel;
    }

    public long getId() {
        return id;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public List<Transferencia> getTransferencia() {
        return this.transferencias;
    }

    public void addTransferencia(Transferencia transferencia) { this.transferencias.add(transferencia); }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Conta{");
        sb.append("id=").append(id);
        sb.append(", nomeResponsavel='").append(nomeResponsavel).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
