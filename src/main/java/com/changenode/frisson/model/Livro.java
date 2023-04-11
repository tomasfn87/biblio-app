package com.changenode.frisson.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

    public Integer idLivro;
    public String isbn;
    public String titulo;
    public Integer ano;
    public Integer edicao;
    public java.util.List<Categorias> categorias;
    public java.util.List<Autores> autores;
    public Editoras editora;
    public List<String> assuntos;
    public List<String> palavrasChaves;
    public Integer prazo;
    @DateTimeFormat
    public Date livroRegistro;
    @DateTimeFormat
    public Date livroExclusao;
    public String observacoes;
}
