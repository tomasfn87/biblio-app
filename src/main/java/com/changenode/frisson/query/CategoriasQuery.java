package com.changenode.frisson.query;

import com.changenode.frisson.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriasQuery extends JpaRepository<Categorias, Long> {
    List<Categorias> findByDescricaoContainingIgnoreCase(String descricao);
}
