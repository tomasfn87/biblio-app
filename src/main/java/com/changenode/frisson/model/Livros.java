package com.changenode.frisson.model;

import com.changenode.frisson.classes.CamposMultiplos;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "livros", schema = "public")
public class Livros {

    private Long idLivro;
    private String isbn;
    private String titulo;
    private Integer ano;
    private Integer edicao;
    private Long idEditora;
    private String assuntos;
    /**
     *  Os atributos de categoria e autores devem ser datas
     *  por tabelas auxiliares com chaves estrangeiras dos
     *  livros e categoria/autores.
     */
    private String palavrasChaves;
    private Integer prazo;
    @DateTimeFormat
    private Date livroRegistro;
    @DateTimeFormat
    private Date livroExclusao;
    private String observacoes;

    @Id()
    @Column(name = "id_livro", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getIdLivro() {
        return idLivro;
    }
    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    @Basic
    @Column(name = "isbn")
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        if(!isbn.isBlank())
            this.isbn = isbn.toUpperCase();
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
    public void setAno(String ano) {
        if(!ano.isBlank())
            this.ano = Integer.valueOf(ano);
    }

    @Basic
    @Column(name = "edicao")
    public Integer getEdicao() {
        return edicao;
    }
    public void setEdicao(String edicao) {
        if(!edicao.isBlank())
            this.edicao = Integer.valueOf(edicao);
    }

    @Basic
    @Column(name = "id_editora")
    public Long getIdEditora() {
        return idEditora;
    }
    public void setIdEditora(String idEditora) {
        if(!idEditora.isBlank())
            this.idEditora = Long.valueOf(idEditora);
    }

    @Basic
    @Column(name = "assuntos")
    public String getAssuntos() {
        return assuntos;
    }
    public void setAssuntos(String assuntos) {
        if(!assuntos.isBlank())
            this.assuntos = new CamposMultiplos(assuntos, ";'").toString();
    }

    @Basic
    @Column(name = "palavras_chaves")
    public String getPalavrasChaves() {
        return palavrasChaves;
    }
    public void setPalavrasChaves(String palavrasChaves) {
        if(!palavrasChaves.isBlank())
            this.palavrasChaves = new CamposMultiplos(palavrasChaves, ";'").toString();
    }

    @Basic
    @Column(name = "prazo")
    public Integer getPrazo() {
        return prazo;
    }
    public void setPrazo(String prazo) {
        if(!prazo.isBlank())
            this.prazo = Integer.valueOf(prazo);
    }

    @Basic
    @Column(name = "livro_registro")
    public Date getLivroRegistro() {
        return livroRegistro;
    }
    public void setLivroRegistro(String livroRegistro) {
        if(!livroRegistro.isBlank())
            this.livroRegistro = Date.valueOf(livroRegistro);
    }

    @Basic
    @Column(name = "livro_exclusao")
    public Date getLivroExclusao() {
        return livroExclusao;
    }
    public void setLivroExclusao(String livroExclusao) {
        if(!livroExclusao.isBlank())
            this.livroExclusao = Date.valueOf(livroExclusao);
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
        return idLivro == that.idLivro &&
                Objects.equals(isbn, that.isbn) &&
                Objects.equals(titulo,that.titulo) &&
                Objects.equals(ano,that.ano) &&
                Objects.equals(edicao,that.edicao) &&
                Objects.equals(idEditora,that.idEditora) &&
                Objects.equals(assuntos,that.assuntos) &&
                Objects.equals(palavrasChaves,that.palavrasChaves) &&
                Objects.equals(prazo,that.prazo) &&
                Objects.equals(livroRegistro,that.livroRegistro) &&
                Objects.equals(livroExclusao,that.livroExclusao) &&
                Objects.equals(observacoes, that.observacoes)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            idLivro,
            isbn,
            titulo,
            ano,
            edicao,
            idEditora,
            assuntos,
            palavrasChaves,
            prazo,
            livroRegistro,
            livroExclusao,
            observacoes
        );
    }
}
