package com.changenode.frisson.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Exemplar {

    public Integer idExemplar;
    public Livro idLivro;
    @DateTimeFormat
    public Date exemplarCadastro;
    @DateTimeFormat
    public Date exemplarExclusao;
    public CondicoesEnum condicoes;
    public String observacoes;
}
