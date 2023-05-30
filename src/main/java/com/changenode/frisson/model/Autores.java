package com.changenode.frisson.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "autores", schema = "public")
public class Autores implements Serializable {
   private Long id;
   private UUID idAutor;
   private String nome;
   private String sobrenome;
   private String descricao;

   @Id()
   @Column(name = "id", nullable = false)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public Long getId() {
      return this.id;
   }
   public void setId(Long id) {
      this.id = id;
   }

   @Basic
   @Column(name = "id_autor", nullable = false)
   public UUID getIdAutor() {
      return this.idAutor;
   }
   public void setIdAutor(UUID idAutor) {
      this.idAutor = idAutor;
   }

   @Basic
   @Column(name = "nome", nullable = false)
   public String getNome() { return this.nome; }
   public void setNome(@NotNull String nome) { this.nome = nome.toUpperCase(); }

   @Basic
   @Column(name = "sobrenome", nullable = false)
   public String getSobrenome() {
      return this.sobrenome;
   }
   public void setSobrenome(@NotNull String sobrenome) {
      this.sobrenome = sobrenome.toUpperCase();
   }

   @Basic
   @Column(name = "descricao")
   public String getDescricao() {
      return this.descricao;
   }
   public void setDescricao(String descricao) {
      this.descricao = descricao;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Autores that = (Autores) o;
      return id == that.id &&
              Objects.equals(idAutor, that.idAutor) &&
              Objects.equals(nome, that.nome) &&
              Objects.equals(sobrenome, that.sobrenome) &&
              Objects.equals(descricao, that.descricao)
              ;
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, idAutor, nome, sobrenome, descricao);
   }

}
