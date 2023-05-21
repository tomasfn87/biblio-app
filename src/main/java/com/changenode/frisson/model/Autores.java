package com.changenode.frisson.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "autores", schema = "public")
public class Autores implements Serializable {

   @Id
   @Column(name = "id", nullable = false)
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;

   @Basic
   @Column(name = "idAutor", nullable = false)
   private UUID idAutor;

   @Basic
   @Column(name = "nome")
   private String nome;

   @Basic
   @Column(name = "sobrenome")
   private String sobrenome;

   @Basic
   @Column(name = "descricao")
   private String descricao;

   public int getId() {
      return this.id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public UUID getIdAutor() {
      return this.idAutor;
   }

   public void setIdAutor(UUID idAutor) {
      this.idAutor = idAutor;
   }


   public String getNome() {
      return this.nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }


   public String getSobrenome() {
      return this.sobrenome;
   }

   public void setSobrenome(String sobrenome) {
      this.sobrenome = sobrenome;
   }


   public String getDescricao() {
      return this.descricao;
   }

   public void setDescricao(String descricao) {
      this.descricao = descricao;
   }
}
