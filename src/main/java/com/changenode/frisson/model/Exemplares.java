package com.changenode.frisson.model;

import com.changenode.frisson.enums.CondicoesEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "exemplares", schema = "public")
public class Exemplares {

    private Long idExemplar;
    private Long idLivro;
    @DateTimeFormat
    private Date exemplarCadastro;
    @DateTimeFormat
    private Date exemplarExclusao;
    private CondicoesEnum condicoes;
    private String observacoes;

    @Id()
    @Column(name = "id_exemplar", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getIdExemplar() {
        return idExemplar;
    }
    public void setIdExemplar(Long idExemplar) { this.idExemplar = idExemplar; }

    @Basic
    @Column(name = "id_livro", nullable = false)
    public Long getidLivro() {
        return idLivro;
    }
    public void setIdLivro(String idLivro) {
        if(!idLivro.isBlank())
            this.idLivro = Long.valueOf(idLivro);
    }

    @Basic
    @Column(name = "exemplar_cadastro")
    public Date getExemplarCadastro() {
        return exemplarCadastro;
    }
    public void setExemplarCadastro(String exemplarCadastro) {
        if(!exemplarCadastro.isBlank())
        this.exemplarCadastro = Date.valueOf(exemplarCadastro);
    }

    @Basic
    @Column(name = "exemplar_exclusao")
    public Date getExemplarExclusao() {
        return exemplarExclusao;
    }
    public void setExemplarExclusao(String exemplarExclusao) {
        if(!exemplarExclusao.isBlank())
            this.exemplarExclusao = Date.valueOf(exemplarExclusao);
    }

    @Basic
    @Column(name = "condicoes")
    public int getCondicoes() { return condicoes.ordinal(); }
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
        return idExemplar == that.idExemplar &&
                Objects.equals(idLivro, that.idLivro) &&
                Objects.equals(exemplarCadastro, that.exemplarCadastro) &&
                Objects.equals(exemplarExclusao, that.exemplarExclusao) &&
                Objects.equals(condicoes, that.condicoes) &&
                Objects.equals(observacoes, that.observacoes)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            idExemplar,
            idLivro,
            exemplarCadastro,
            exemplarExclusao,
            condicoes,
            observacoes
        );
    }
}
