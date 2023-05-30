package com.changenode.frisson.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "categorias", schema = "public")
public class Categorias implements Serializable {

    private Long idCategoria;
    private String descricao;

    @Id()
    @Column(name = "id_categoria", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getIdCategoria() {
        return this.idCategoria;
    }
    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
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
        return idCategoria == that.idCategoria    &&
                Objects.equals(descricao, that.descricao)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategoria, descricao);
    }
}
