package com.changenode.frisson.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Autores {

   public Integer idAutor;
   public String nome;
   public String sobrenome;
   public String descricao;
}
