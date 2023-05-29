package com.changenode.frisson.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "editoras", schema = "public")
public class Editoras {

    private Long id_editora;
    private String nome;

    @Id()
    @Column(name = "id_editora", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId_editora() {
        return id_editora;
    }
    public void setId_editora(Long id_editora) {
        this.id_editora = id_editora;
    }

    @Basic
    @Column(name = "nome", unique = true, nullable = false)
    public String getNome() {
        return nome;
    }
    public void setNome(@NotNull String nome) {
        this.nome = nome.toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Editoras that = (Editoras) o;
        return id_editora == that.id_editora    &&
                Objects.equals(nome, that.nome)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_editora, nome);
    }
}
