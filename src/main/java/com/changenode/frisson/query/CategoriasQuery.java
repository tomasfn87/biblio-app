package com.changenode.frisson.query;

import com.changenode.frisson.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriasQuery extends JpaRepository<Categorias, Long> {
}
