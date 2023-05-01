package com.changenode.frisson.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Colaborador {

    @Id
    public Integer idColaboraador;
    @DateTimeFormat
    public Date colaboradorCadastro;
    @DateTimeFormat
    public Date colaboradorExclusao ;
    public String observacoes;


}
