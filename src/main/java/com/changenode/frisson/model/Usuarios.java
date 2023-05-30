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
    private Long idUsuario;
    private String nome;
    private Long cpf;
    private String endereco;
    private String telefone;
    private String whatsapp;
    @Email
    private String email;
    @DateTimeFormat
    private Date usuarioCadastro;
    @DateTimeFormat
    private Date usuarioExclusao;
    private String observacao;


    public Long getIdUsuario() {
        return this.idUsuario;
    }
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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
        this.endereco = endereco;
    }

    @Basic
    @Column(name = "telefone")
    public String getTelefone() {
        return telefone;
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
            this.whatsapp = whatsapp;
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
    public Date getUsuarioCadastro() {
        return usuarioCadastro;
    }
    public void setUsuarioCadastro(String usuarioCadastro) {
        if(!usuarioCadastro.isBlank())
            this.usuarioCadastro = Date.valueOf(usuarioCadastro);
    }

    @Basic
    @Column(name = "usuario_exclusao")
    public Date getUsuarioExclusao() {
        return usuarioExclusao;
    }
    public void setUsuarioExclusao(String usuarioExclusao) {
        if(!usuarioExclusao.isBlank())
            this.usuarioExclusao = Date.valueOf(usuarioExclusao);
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
        return idUsuario == that.idUsuario &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(cpf, that.cpf) &&
                Objects.equals(endereco, that.endereco) &&
                Objects.equals(telefone, that.telefone) &&
                Objects.equals(whatsapp, that.whatsapp) &&
                Objects.equals(email, that.email) &&
                Objects.equals(usuarioCadastro, that.usuarioCadastro) &&
                Objects.equals(usuarioExclusao, that.usuarioExclusao) &&
                Objects.equals(observacao, that.observacao)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            idUsuario,
            nome,
            cpf,
            endereco,
            telefone,
            whatsapp,
            email,
            usuarioCadastro,
            usuarioExclusao,
            observacao
        );
    }
}
