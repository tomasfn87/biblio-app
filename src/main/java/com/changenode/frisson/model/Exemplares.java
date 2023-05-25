package com.changenode.frisson.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
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
    public void setId_exemplar(Long id_exemplar) {
        this.id_exemplar = id_exemplar;
    }

    @Basic
    @Column(name = "id_livro", nullable = false)
    public Long getId_livro() {
        return id_livro;
    }
    public void setId_livro(Long id_livro) {
        this.id_livro = id_livro;
    }
    public void setId_livro(Livros livro) {this.id_livro = livro.getId_livro();}

    @Basic
    @Column(name = "exemplar_cadastro")
    public Date getExemplar_cadastro() {
        return exemplar_cadastro;
    }
    public void setExemplar_cadastro(Date exemplar_cadastro) {
        this.exemplar_cadastro = exemplar_cadastro;
    }

    @Basic
    @Column(name = "exemplar_exclusao")
    public Date getExemplar_exclusao() {
        return exemplar_exclusao;
    }
    public void setExemplar_exclusao(Date exemplar_exclusao) {
        this.exemplar_exclusao = exemplar_exclusao;
    }

    @Basic
    @Column(name = "condicoes")
    public CondicoesEnum getCondicoes() {
        return condicoes;
    }
    public void setCondicoes(CondicoesEnum condicoes) {
        this.condicoes = condicoes;
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
