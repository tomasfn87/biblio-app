package com.changenode.frisson.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "emprestimos", schema = "public")
public class Emprestimos {

    private Long id_emprestimo;
    private Long id_exemplar;
    private Long id_usuario;
    private Long id_colaborador;
    @DateTimeFormat
    private Date data_reserva;
    @DateTimeFormat
    private Date data_retirada;
    @DateTimeFormat
    private Date data_devolucao;
    @DateTimeFormat
    private Date data_cancelamento;
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
    public void setId_emprestimo(@NotNull Emprestimos emprestimo) {
        this.id_emprestimo = emprestimo.getId_emprestimo();
    }

    @Basic
    @Column(name = "id_exemplar", nullable = false)
    public Long getId_exemplar() {
        return id_exemplar;
    }
    public void setId_exemplar(Long id_exemplar) {
        this.id_exemplar = id_exemplar;
    }
    public void setId_exemplar(@NotNull Exemplares exemplar) {
        this.id_exemplar = exemplar.getId_exemplar();
    }

    @Basic
    @Column(name = "id_usuario", nullable = false)
    public Long getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }
    public void setId_usuario(@NotNull Usuarios usuario) {
        this.id_usuario = usuario.getId();
    }

    @Basic
    @Column(name = "id_colaborador", nullable = false)
    public Long getId_colaborador() {
        return id_colaborador;
    }
    public void setId_colaborador(Long id_colaborador) {
        this.id_colaborador = id_colaborador;
    }
    public void setId_colaborador(@NotNull Colaboradores colaborador) { this.id_colaborador = colaborador.getId(); }

    @Basic
    @Column(name = "data_reserva", nullable = false)
    public Date getData_reserva() {
        return data_reserva;
    }
    public void setData_reserva(Date data_reserva) {
        this.data_reserva = data_reserva;
    }

    @Basic
    @Column(name = "data_retirada")
    public Date getData_retirada() {
        return data_retirada;
    }
    public void setData_retirada(Date data_retirada) {
        this.data_retirada = data_retirada;
    }

    @Basic
    @Column(name = "data_devolucao")
    public Date getData_devolucao() {
        return data_devolucao;
    }
    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    @Basic
    @Column(name = "data_cancelamento")
    public Date getData_cancelamento() {
        return data_cancelamento;
    }
    public void setData_cancelamento(Date data_cancelamento) {
        this.data_cancelamento = data_cancelamento;
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
                Objects.equals(id_emprestimo, that.id_emprestimo) &&
                Objects.equals(id_exemplar, that.id_exemplar) &&
                Objects.equals(id_usuario, that.id_usuario) &&
                Objects.equals(id_colaborador, that.id_colaborador) &&
                Objects.equals(data_reserva, that.data_reserva) &&
                Objects.equals(data_retirada, that.data_retirada) &&
                Objects.equals(data_devolucao, that.data_devolucao) &&
                Objects.equals(data_cancelamento, that.data_cancelamento) &&
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
                data_reserva,
                data_retirada,
                data_devolucao,
                data_cancelamento,
                observacoes
        );
    }
}
