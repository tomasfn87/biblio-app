package com.changenode.frisson.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "categorias", schema = "public")
public class Categorias implements Serializable {

    private Long id_categoria;
    private String descricao;

    @Id()
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId_categoria() {
        return this.id_categoria;
    }
    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    @Basic
    @Column(name = "descricao", unique = true, nullable = false)
    public String getDescricao() {
        return this.descricao;
    }
    public void setDescricao(@NotNull String descricao) {
        this.descricao = descricao.toLowerCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categorias that = (Categorias) o;
        return id_categoria == that.id_categoria    &&
                Objects.equals(descricao, that.descricao)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_categoria, descricao);
    }
}
