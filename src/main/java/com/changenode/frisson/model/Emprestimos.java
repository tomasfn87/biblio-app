package com.changenode.frisson.model;

import org.springframework.format.annotation.DateTimeFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "emprestimos", schema = "public")
public class Emprestimos {

    private Long idEmprestimo;
    private Long idExemplar;
    private Long idUsuario;
    private Long idColaborador;
    @DateTimeFormat
    private Date emprestimoReserva;
    @DateTimeFormat
    private Date emprestimoRetirada;
    @DateTimeFormat
    private Date emprestimoDevolucao;
    @DateTimeFormat
    private Date emprestimoCancelamento;
    private String observacoes;

    @Id()
    @Column(name = "id_emprestimo", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getIdEmprestimo() {
        return idEmprestimo;
    }
    public void setIdEmprestimo(Long idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    @Basic
    @Column(name = "id_exemplar", nullable = false)
    public Long getIdExemplar() {
        return idExemplar;
    }
    public void setIdExemplar(String idExemplar) {
        if(!idExemplar.isBlank())
            this.idExemplar = Long.valueOf(idExemplar);
    }

    @Basic
    @Column(name = "id_usuario", nullable = false)
    public Long getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(String idUsuario) {
        if(!idUsuario.isBlank())
            this.idUsuario = Long.valueOf(idUsuario);
    }

    @Basic
    @Column(name = "id_colaborador", nullable = false)
    public Long getIdColaborador() {
        return idColaborador;
    }
    public void setIdColaborador(String idColaborador) {
        if(!idColaborador.isBlank())
            this.idColaborador = Long.valueOf(idColaborador);
    }

    @Basic
    @Column(name = "emprestimo_reserva", nullable = false)
    public Date getEmprestimoReserva() {
        return this.emprestimoReserva;
    }
    public void setEmprestimoReserva(String emprestimoReserva) {
        if(!emprestimoReserva.isBlank())
            this.emprestimoReserva = Date.valueOf(emprestimoReserva);
    }

    @Basic
    @Column(name = "emprestimo_retirada")
    public Date getEmprestimoRetirada() {
        return this.emprestimoRetirada;
    }
    public void setEmprestimoRetirada(String emprestimoRetirada) {
        if(!emprestimoRetirada.isBlank())
            this.emprestimoRetirada = Date.valueOf(emprestimoRetirada);
    }

    @Basic
    @Column(name = "emprestimo_devolucao")
    public Date getEmprestimoDevolucao() { return this.emprestimoDevolucao; }
    public void setEmprestimoDevolucao(String emprestimoDevolucao) {
        if(!emprestimoDevolucao.isBlank())
            this.emprestimoDevolucao = Date.valueOf(emprestimoDevolucao);
    }

    @Basic
    @Column(name = "emprestimo_cancelamento")
    public Date getEmprestimoCancelamento() {
        return this.emprestimoCancelamento;
    }
    public void setEmprestimoCancelamento(String emprestimoCancelamento) {
        if (emprestimoCancelamento != null && !emprestimoCancelamento.isBlank())
            this.emprestimoDevolucao = Date.valueOf(emprestimoCancelamento);
    }

    @Basic
    @Column(name = "observacoes")
    public String getObservacoes() { return this.observacoes; }
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emprestimos that = (Emprestimos) o;
        return idEmprestimo == that.idEmprestimo    &&
                Objects.equals(idExemplar, that.idExemplar) &&
                Objects.equals(idUsuario, that.idUsuario) &&
                Objects.equals(idColaborador, that.idColaborador) &&
                Objects.equals(emprestimoReserva, that.emprestimoReserva) &&
                Objects.equals(emprestimoRetirada, that.emprestimoRetirada) &&
                Objects.equals(emprestimoDevolucao, that.emprestimoDevolucao) &&
                Objects.equals(emprestimoCancelamento, that.emprestimoCancelamento) &&
                Objects.equals(observacoes, that.observacoes)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                idEmprestimo,
                idExemplar,
                idUsuario,
                idColaborador,
                emprestimoReserva,
                emprestimoRetirada,
                emprestimoDevolucao,
                emprestimoCancelamento,
                observacoes
        );
    }
}
