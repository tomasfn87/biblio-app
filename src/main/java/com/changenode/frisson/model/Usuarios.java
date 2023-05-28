package com.changenode.frisson.model;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "usuarios", schema = "public")
public class Usuarios implements Serializable {
    private Long id;
    private String nome;
    @CPF
    @Valid
    private Integer cpf;
    private String endereco;
    private Integer telefone;
    private Integer whatsApp;
    @Email
    @Valid
    private String email;
    @DateTimeFormat
    private Date usuario_cadastro;
    @DateTimeFormat
    private Date usuario_exclusao;
    private String observacao;

    @Id()
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public Integer getCpf() {
        return cpf;
    }
    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    @Basic
    @Column(name = "endereco")
    public String getEndereco() {
        return endereco;
    }

    /** Verificar viabilidade técnica do parâmetro com classe Endereço
     *  para o uso do Model na página.
     */
    public void setEndereco(String endereco) {
        this.endereco = new Enderecos(endereco).toString();
    }
    public void setEndereco(Enderecos endereco) {
        this.endereco = endereco.toString();
    }

    @Basic
    @Column(name = "telefone")
    public Integer getTelefone() {
        return telefone;
    }
    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    @Basic
    @Column(name = "whatsapp")
    public Integer getWhatsApp() {
        return whatsApp;
    }
    public void setWhatsApp(Integer whatsApp) {
        this.whatsApp = whatsApp;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = (email==null ? null : email.toLowerCase());
    }

    @Basic
    @Column(name = "usuario_cadastro", nullable = false)
    public Date getUsuario_cadastro() {
        return usuario_cadastro;
    }
    public void setUsuario_cadastro(Date usuario_cadastro) {
        this.usuario_cadastro = usuario_cadastro;
    }

    @Basic
    @Column(name = "usuario_exclusao")
    public Date getUsuario_exclusao() {
        return usuario_exclusao;
    }
    public void setUsuario_exclusao(Date usuario_exclusao) {
        this.usuario_exclusao = usuario_exclusao;
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
        return id == that.id &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(cpf,that.cpf) &&
                Objects.equals(endereco,that.endereco) &&
                Objects.equals(telefone,that.telefone) &&
                Objects.equals(whatsApp,that.whatsApp) &&
                Objects.equals(email,that.email) &&
                Objects.equals(usuario_cadastro,that.usuario_cadastro) &&
                Objects.equals(usuario_exclusao,that.usuario_exclusao) &&
                Objects.equals(observacao, that.observacao)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            nome,
            cpf,
            endereco,
            telefone,
            whatsApp,
            email,
            usuario_cadastro,
            usuario_exclusao,
            observacao
        );
    }
}
