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
    private Long id_usuario;
    private String cargo;
    private String nome;
    private Long cpf;
    private String endereco;
    private String telefone;
    private String whatsapp;
    @Email
    private String email;
    @DateTimeFormat
    private Date colaborador_cadastro;
    @DateTimeFormat
    private Date colaborador_exclusao;
    private String observacao;

    public Long getId_usuario() {
        return this.id_usuario;
    }
    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
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
    public Date getColaborador_cadastro() {
        return colaborador_cadastro;
    }
    public void setColaborador_cadastro(String colaborador_cadastro) {
        if(!colaborador_cadastro.isBlank())
            this.colaborador_cadastro = Date.valueOf(colaborador_cadastro);
    }

    @Basic
    @Column(name = "colaborador_exclusao")
    public Date getColaborador_exclusao() {
        return colaborador_exclusao;
    }
    public void setColaborador_exclusao(String colaborador_exclusao) {
        if(!colaborador_exclusao.isBlank())
            this.colaborador_exclusao = Date.valueOf(colaborador_exclusao);
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
        return id_usuario == that.id_usuario &&
                Objects.equals(cargo, that.cargo) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(cpf,that.cpf) &&
                Objects.equals(endereco,that.endereco) &&
                Objects.equals(telefone,that.telefone) &&
                Objects.equals(whatsapp,that.whatsapp) &&
                Objects.equals(email,that.email) &&
                Objects.equals(colaborador_cadastro,that.colaborador_cadastro) &&
                Objects.equals(colaborador_exclusao,that.colaborador_exclusao) &&
                Objects.equals(observacao, that.observacao)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id_usuario,
                cargo,
                nome,
                cpf,
                endereco,
                telefone,
                whatsapp,
                email,
                colaborador_cadastro,
                colaborador_exclusao,
                observacao
        );
    }
}
