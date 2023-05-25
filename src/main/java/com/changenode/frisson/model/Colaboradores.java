package com.changenode.frisson.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "colaboradores", schema = "public")
public class Colaboradores extends Usuarios{
    /* private Long id_colaboraador;
    @DateTimeFormat
    private Date colaborador_cadastro;
    @DateTimeFormat
    private Date colaborador_exclusao ;
    private String observacoes;

    @Id()
    @Column(name = "id_colaborador", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId_colaboraador() {
        return id_colaboraador;
    }

    public void setId_colaboraador(Long id_colaboraador) {
        this.id_colaboraador = id_colaboraador;
    }

    @Basic
    @Column(name = "colaborador_cadastro")
    public Date getColaborador_cadastro() {
        return colaborador_cadastro;
    }
    public void setColaborador_cadastro(Date colaborador_cadastro) {
        this.colaborador_cadastro = colaborador_cadastro;
    }

    @Basic
    @Column(name = "colaborador_exclusao")
    public Date getColaborador_exclusao() {
        return colaborador_exclusao;
    }
    public void setColaborador_exclusao(Date colaborador_exclusao) {
        this.colaborador_exclusao = colaborador_exclusao;
    }

    @Basic
    @Column(name = "observacoes")
    public String getObservacoes() {
        return observacoes;
    }
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    */
}
