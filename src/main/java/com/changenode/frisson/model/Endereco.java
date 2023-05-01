package com.changenode.frisson.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    public TipoEnum tipo;
    public String logradouro;
    public Integer numero;
    public String complemento;
    public String bairro;
    public String municipio;
    public Character estado;
    public Integer cep;

}
