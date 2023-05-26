package com.changenode.frisson.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "usuarios", schema = "public")
public class Usuarios implements Serializable {
    @Id
    @Column(name = "id_usuario", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    private String nome;
    private Long cpf;
    private String endereco;
    private String telefone;
    private String whatsapp;
    @Email
    private String email;
    @DateTimeFormat
    private Date usuario_cadastro;
    @DateTimeFormat
    private Date usuario_exclusao;
    private String observacao;


    public Long getId_usuario() {
        return this.id_usuario;
    }
    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
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
    @Column(name = "usuario_cadastro", nullable = false)
    public Date getUsuario_cadastro() {
        return usuario_cadastro;
    }
    public void setUsuario_cadastro(String usuario_cadastro) {
        this.usuario_cadastro = Date.valueOf(usuario_cadastro);
    }

    @Basic
    @Column(name = "usuario_exclusao")
    public Date getUsuario_exclusao() {
        return usuario_exclusao;
    }
    public void setUsuario_exclusao(String usuario_exclusao) {
        if(!usuario_exclusao.isBlank())
            this.usuario_exclusao = Date.valueOf(usuario_exclusao);
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
        Usuarios that = (Usuarios) o;
        return id_usuario == that.id_usuario &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(cpf,that.cpf) &&
                Objects.equals(endereco,that.endereco) &&
                Objects.equals(telefone,that.telefone) &&
                Objects.equals(whatsapp,that.whatsapp) &&
                Objects.equals(email,that.email) &&
                Objects.equals(usuario_cadastro,that.usuario_cadastro) &&
                Objects.equals(usuario_exclusao,that.usuario_exclusao) &&
                Objects.equals(observacao, that.observacao)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id_usuario,
            nome,
            cpf,
            endereco,
            telefone,
            whatsapp,
            email,
            usuario_cadastro,
            usuario_exclusao,
            observacao
        );
    }
}
