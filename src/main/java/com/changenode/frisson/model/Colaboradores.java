package com.changenode.frisson.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "colaboradores", schema = "public")
public class Colaboradores{

    //nome da coluna está como id_usuario por problema de dependência de chaves estrangeiras. Não mexer
    @Id
    @Column(name = "id_usuario", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String cargo;
    private String nome;
    private Long cpf;
    private String endereco;
    private String telefone;
    private String whatsapp;
    @Email
    private String email;
    @DateTimeFormat
    private Date colaboradorCadastro;
    @DateTimeFormat
    private Date colaboradorExclusao;
    private String observacao;

    public Long getIdUsuario() {
        return this.idUsuario;
    }
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    @Basic
    @Column(name = "cargo", nullable = false)
    public String getCargo() {
        return this.cargo;
    }
    public void setCargo(String cargo) {
        if(!cargo.isBlank())
            this.cargo = cargo.toUpperCase();
    }

    @Basic
    @Column(name = "nome", nullable = false)
    public String getNome() {
        return this.nome;
    }
    public void setNome(@NotNull String nome) {
        if(!nome.isBlank())
            this.nome = nome.toUpperCase();
    }

    @Basic
    @Column(name = "cpf", unique = true, nullable = false)
    public Long getCpf() {
        return this.cpf;
    }
    public void setCpf(String cpf) {
        if(!cpf.isBlank())
            this.cpf = Long.valueOf(cpf);
    }

    @Basic
    @Column(name = "endereco")
    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Basic
    @Column(name = "telefone")
    public String getTelefone() {
        return this.telefone;
    }
    public void setTelefone(String telefone) {
        if(!telefone.isBlank())
            this.telefone = telefone;
    }

    @Basic
    @Column(name = "whatsapp")
    public String getWhatsapp() {
        return whatsapp;
    }
    public void setWhatsapp(String whatsapp) {
        if(!whatsapp.isBlank())
            this.whatsapp = whatsapp;//Long.valueOf(whatsapp);
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        if(!email.isBlank())
            this.email = email.toLowerCase();
    }

    @Basic
    @Column(name = "colaborador_cadastro", nullable = false)
    public Date getColaboradorCadastro() {
        return colaboradorCadastro;
    }
    public void setColaboradorCadastro(String colaboradorCadastro) {
        if(!colaboradorCadastro.isBlank())
            this.colaboradorCadastro = Date.valueOf(colaboradorCadastro);
    }

    @Basic
    @Column(name = "colaborador_exclusao")
    public Date getColaboradorExclusao() {
        return colaboradorExclusao;
    }
    public void setColaboradorExclusao(String colaboradorExclusao) {
        if(!colaboradorExclusao.isBlank())
            this.colaboradorExclusao = Date.valueOf(colaboradorExclusao);
    }

    @Basic
    @Column(name = "observacao")
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colaboradores that = (Colaboradores) o;
        return idUsuario == that.idUsuario &&
                Objects.equals(cargo, that.cargo) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(cpf, that.cpf) &&
                Objects.equals(endereco, that.endereco) &&
                Objects.equals(telefone, that.telefone) &&
                Objects.equals(whatsapp, that.whatsapp) &&
                Objects.equals(email, that.email) &&
                Objects.equals(colaboradorCadastro, that.colaboradorCadastro) &&
                Objects.equals(colaboradorExclusao, that.colaboradorExclusao) &&
                Objects.equals(observacao, that.observacao)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                idUsuario,
                cargo,
                nome,
                cpf,
                endereco,
                telefone,
                whatsapp,
                email,
                colaboradorCadastro,
                colaboradorExclusao,
                observacao
        );
    }
}
