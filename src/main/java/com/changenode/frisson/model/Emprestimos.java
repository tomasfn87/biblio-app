package com.changenode.frisson.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "emprestimos", schema = "public")
public class Emprestimos {

    private Long id_emprestimo;
    private Long id_exemplar;
    private Long id_usuario;
    private Long id_colaborador;
    @DateTimeFormat
    private Date emprestimo_reserva;
    @DateTimeFormat
    private Date emprestimo_retirada;
    @DateTimeFormat
    private Date emprestimo_devolucao;
    @DateTimeFormat
    private Date emprestimo_cancelamento;
    private String observacoes;

    @Id()
    @Column(name = "id_emprestimo", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId_emprestimo() {
        return id_emprestimo;
    }
    public void setId_emprestimo(Long id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }

    @Basic
    @Column(name = "id_exemplar", nullable = false)
    public Long getId_exemplar() {
        return id_exemplar;
    }
    public void setId_exemplar(String id_exemplar) {
        this.id_exemplar = Long.valueOf(id_exemplar);
    }

    @Basic
    @Column(name = "id_usuario", nullable = false)
    public Long getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(String id_usuario) {
        this.id_usuario = Long.valueOf(id_usuario);
    }

    @Basic
    @Column(name = "id_colaborador", nullable = false)
    public Long getId_colaborador() {
        return id_colaborador;
    }
    public void setId_colaborador(String id_colaborador) {
        this.id_colaborador = Long.valueOf(id_colaborador);
    }

    @Basic
    @Column(name = "emprestimo_reserva", nullable = false)
    public Date getData_reserva() {
        return emprestimo_reserva;
    }
    public void setData_reserva(String emprestimo_reserva) {

        if(!emprestimo_reserva.isBlank())
            this.emprestimo_reserva = Date.valueOf(emprestimo_reserva);
    }

    @Basic
    @Column(name = "emprestimo_retirada")
    public Date getData_retirada() {
        return emprestimo_retirada;
    }
    public void setData_retirada(String emprestimo_retirada) {
        if(!emprestimo_retirada.isBlank())
            this.emprestimo_retirada = Date.valueOf(emprestimo_retirada);
    }

    @Basic
    @Column(name = "emprestimo_devolucao")
    public Date getData_devolucao() {
        return emprestimo_devolucao;
    }
    public void setData_devolucao(String emprestimo_devolucao) {
        if(!emprestimo_devolucao.isBlank())
            this.emprestimo_devolucao = Date.valueOf(emprestimo_devolucao);
    }

    @Basic
    @Column(name = "emprestimo_cancelamento")
    public Date getData_cancelamento() {
        return emprestimo_cancelamento;
    }
    public void setData_cancelamento(String emprestimo_cancelamento) {
        if(!emprestimo_cancelamento.isBlank())
            this.emprestimo_cancelamento = Date.valueOf(emprestimo_cancelamento);
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
        Emprestimos that = (Emprestimos) o;
        return id_emprestimo == that.id_emprestimo    &&
                Objects.equals(id_exemplar, that.id_exemplar) &&
                Objects.equals(id_usuario, that.id_usuario) &&
                Objects.equals(id_colaborador, that.id_colaborador) &&
                Objects.equals(emprestimo_reserva, that.emprestimo_reserva) &&
                Objects.equals(emprestimo_retirada, that.emprestimo_retirada) &&
                Objects.equals(emprestimo_devolucao, that.emprestimo_devolucao) &&
                Objects.equals(emprestimo_cancelamento, that.emprestimo_cancelamento) &&
                Objects.equals(observacoes, that.observacoes)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id_emprestimo,
                id_exemplar,
                id_usuario,
                id_colaborador,
                emprestimo_reserva,
                emprestimo_retirada,
                emprestimo_devolucao,
                emprestimo_cancelamento,
                observacoes
        );
    }
}
