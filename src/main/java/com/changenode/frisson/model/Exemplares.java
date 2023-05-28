package com.changenode.frisson.model;

import com.changenode.frisson.enums.CondicoesEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "exemplares", schema = "public")
public class Exemplares {

    private Long id_exemplar;
    private Long id_livro;
    @DateTimeFormat
    private Date exemplar_cadastro;
    @DateTimeFormat
    private Date exemplar_exclusao;
    private CondicoesEnum condicoes;
    private String observacoes;

    @Id()
    @Column(name = "id_exemplar", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId_exemplar() {
        return id_exemplar;
    }
    public void setId_exemplar(Long id_exemplar) { this.id_exemplar = id_exemplar; }

    @Basic
    @Column(name = "id_livro", nullable = false)
    public Long getId_livro() {
        return id_livro;
    }
    public void setId_livro(String id_livro) {
        if(!id_livro.isBlank())
            this.id_livro = Long.valueOf(id_livro);
    }

    @Basic
    @Column(name = "exemplar_cadastro")
    public Date getExemplar_cadastro() {
        return exemplar_cadastro;
    }
    public void setExemplar_cadastro(String exemplar_cadastro) {
        if(!exemplar_cadastro.isBlank())
        this.exemplar_cadastro = Date.valueOf(exemplar_cadastro);
    }

    @Basic
    @Column(name = "exemplar_exclusao")
    public Date getExemplar_exclusao() {
        return exemplar_exclusao;
    }
    public void setExemplar_exclusao(String exemplar_exclusao) {
        if(!exemplar_exclusao.isBlank())
            this.exemplar_exclusao = Date.valueOf(exemplar_exclusao);
    }

    @Basic
    @Column(name = "condicoes")
    public int getCondicoes() {
        return condicoes.ordinal();
    }
    public void setCondicoes(String condicoes) {
        if(!condicoes.isBlank())
            this.condicoes = CondicoesEnum.valueOf(condicoes);
        else
            this.condicoes = CondicoesEnum.nao_declarado;
    }

    @Basic
    @Column(name = "observacoes")
    public String getObservacoes() {
        return observacoes;
    }
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exemplares that = (Exemplares) o;
        return id_exemplar == that.id_exemplar &&
                Objects.equals(id_livro, that.id_livro) &&
                Objects.equals(exemplar_cadastro, that.exemplar_cadastro) &&
                Objects.equals(exemplar_exclusao, that.exemplar_exclusao) &&
                Objects.equals(condicoes, that.condicoes) &&
                Objects.equals(observacoes, that.observacoes)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id_exemplar,
            id_livro,
            exemplar_cadastro,
            exemplar_exclusao,
            condicoes,
            observacoes
        );
    }
}
