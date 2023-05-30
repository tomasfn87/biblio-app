package com.changenode.frisson.query;

import com.changenode.frisson.model.Livros;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivrosQuery extends JpaRepository<Livros, Long> {
    List<Livros> findByIsbnContainingIgnoreCaseOrTituloContainingIgnoreCaseOrAnoContainingOrEdicaoContainingOrAssuntosContainingIgnoreCaseOrPalavrasChavesContainingIgnoreCaseOrObservacoesContainingIgnoreCase(
            String isbn,
            String titulo,
            String ano,
            String edicao,
            String assuntos,
            String palavrasChaves,
            String observacoes);
}
