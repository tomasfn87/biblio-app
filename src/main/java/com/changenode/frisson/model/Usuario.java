package com.changenode.frisson.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    public Integer idUsuario;
    public String Nome;
    @CPF
    @Valid
    public Integer cpf;
    public Endereco endereco;
    public Integer telefone;
    public Integer whatsApp;
    @Email
    @Valid
    public String email;
    @DateTimeFormat
    public Date usuarioCadastro;
    @DateTimeFormat
    public Date usuarioExclusao;
    public String observacao;

}
