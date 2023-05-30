package com.changenode.frisson.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "editoras", schema = "public")
public class Editoras {

    private Long idEditora;
    private String nome;

    @Id()
    @Column(name = "id_editora", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getIdEditora() {
        return idEditora;
    }
    public void setIdEditora(Long idEditora) {
        this.idEditora = idEditora;
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
        return idEditora == that.idEditora    &&
                Objects.equals(nome, that.nome)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEditora, nome);
    }
}
