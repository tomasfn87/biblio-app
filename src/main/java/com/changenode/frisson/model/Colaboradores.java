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
    @Id
    @Column(name = "id_colaborador", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_colaborador;
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


    public Long getId_colaborador() {
        return this.id_colaborador;
    }
    public void setId_colaborador(Long id_colaborador) {
        this.id_colaborador = id_colaborador;
    }

    @Basic
    @Column(name = "nome", nullable = false)
    public String getNome() {
        return nome;
    }
    public void setNome(@NotNull String nome) {
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
        return endereco;
    }

    public void setEndereco(String endereco) {
        //this.endereco = new Enderecos(endereco).toString();
        this.endereco = endereco;
    }

    @Basic
    @Column(name = "telefone")
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        if(!telefone.isBlank())
            this.telefone = telefone;//Long.valueOf(telefone);
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
    public Date getUsuario_cadastro() {
        return colaborador_cadastro;
    }
    public void setUsuario_cadastro(String colaborador_cadastro) {
        this.colaborador_cadastro = Date.valueOf(colaborador_cadastro);
    }

    @Basic
    @Column(name = "colaborador_exclusao")
    public Date getUsuario_exclusao() {
        return colaborador_exclusao;
    }
    public void setUsuario_exclusao(String colaborador_exclusao) {
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
        return id_colaborador == that.id_colaborador &&
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
                id_colaborador,
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
