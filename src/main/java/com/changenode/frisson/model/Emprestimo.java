package com.changenode.frisson.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo {

    public Integer idEmprestimo;
    public Exemplar idExemplar;
    public Usuario idUsuario;
    public Colaborador idColaborador;
    @DateTimeFormat
    public Date dataReserva;
    @DateTimeFormat
    public Date dataRetirada;
    @DateTimeFormat
    public Date dataDevolucao;
    @DateTimeFormat
    public Date dataCancelamento;
    public String observacoes;
}
