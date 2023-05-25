package com.changenode.frisson.query;

import com.changenode.frisson.model.Livros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrosQuery extends JpaRepository<Livros, Long> {
}
