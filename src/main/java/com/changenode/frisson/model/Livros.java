package com.changenode.frisson.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "livros", schema = "public")
public class Livros {

    private Long id_livro;
    private String isbn;
    private String titulo;
    private Integer ano;
    private Integer edicao;
    private Long id_editora;
    private String assuntos;
    /**
     *  Os atributos de categoria e autores devem ser datas
     *  por tabelas auxiliares com chaves estrangeiras dos
     *  livros e categoria/autores.
     */
    private String palavras_chaves;
    private Integer prazo;
    @DateTimeFormat
    private Date livro_registro;
    @DateTimeFormat
    private Date livro_exclusao;
    private String observacoes;

    @Id()
    @Column(name = "id_livro", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId_livro() {
        return id_livro;
    }
    public void setId_livro(Long id_livro) {
        this.id_livro = id_livro;
    }

    @Basic
    @Column(name = "isbn")
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = (isbn==null ? null : isbn.toUpperCase());
    }

    @Basic
    @Column(name = "titulo")
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(@NotNull String titulo) {
        this.titulo = titulo.toUpperCase();
    }

    @Basic
    @Column(name = "ano")
    public Integer getAno() {
        return ano;
    }
    public void setAno(Integer ano) {
        this.ano = ano;
    }

    @Basic
    @Column(name = "edicao")
    public Integer getEdicao() {
        return edicao;
    }
    public void setEdicao(Integer edicao) {
        this.edicao = edicao;
    }

    @Basic
    @Column(name = "editora")
    public Long getId_editora() {
        return id_editora;
    }
    public void setId_editora(Long id_editora) {
        this.id_editora = id_editora;
    }
    public void setId_editor(Editoras editora) {this.id_editora = editora.getId_editora();}

    @Basic
    @Column(name = "assuntos")
    public String getAssuntos() {
        return assuntos;
    }
    public void setAssuntos(String assuntos) {
        this.assuntos = new CamposMultiplos(assuntos, ";'").toString();
    }
    public void setAssuntos(CamposMultiplos assuntos){ this.assuntos = assuntos.toString(); }

    @Basic
    @Column(name = "palavras_chaves")
    public String getPalavras_chaves() {
        return palavras_chaves;
    }
    public void setPalavras_chaves(String palavras_chaves) {
        this.palavras_chaves = new CamposMultiplos(palavras_chaves, ";'").toString();
    }
    public void setPalavras_chaves(CamposMultiplos palavras_chaves){ this.palavras_chaves = palavras_chaves.toString(); }

    @Basic
    @Column(name = "prazo")
    public Integer getPrazo() {
        return prazo;
    }
    public void setPrazo(Integer prazo) {
        this.prazo = prazo;
    }

    @Basic
    @Column(name = "livro_registro")
    public Date getLivro_registro() {
        return livro_registro;
    }
    public void setLivro_registro(Date livro_registro) {
        this.livro_registro = livro_registro;
    }

    @Basic
    @Column(name = "livro_exclusao")
    public Date getLivro_exclusao() {
        return livro_exclusao;
    }
    public void setLivro_exclusao(Date livro_exclusao) {
        this.livro_exclusao = livro_exclusao;
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
        Livros that = (Livros) o;
        return id_livro == that.id_livro &&
                Objects.equals(isbn, that.isbn) &&
                Objects.equals(titulo,that.titulo) &&
                Objects.equals(ano,that.ano) &&
                Objects.equals(edicao,that.edicao) &&
                Objects.equals(id_editora,that.id_editora) &&
                Objects.equals(assuntos,that.assuntos) &&
                Objects.equals(palavras_chaves,that.palavras_chaves) &&
                Objects.equals(prazo,that.prazo) &&
                Objects.equals(livro_registro,that.livro_registro) &&
                Objects.equals(livro_exclusao,that.livro_exclusao) &&
                Objects.equals(observacoes, that.observacoes)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id_livro,
            isbn,
            titulo,
            ano,
            edicao,
            id_editora,
            assuntos,
            palavras_chaves,
            prazo,
            livro_registro,
            livro_exclusao,
            observacoes
        );
    }
}
