package com.changenode.frisson.query;

import com.changenode.frisson.model.Autores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutoresQuery extends JpaRepository<Autores, Long> {
    List<Autores> findByNomeContainingIgnoreCaseOrSobrenomeContainingIgnoreCaseOrDescricaoContainingIgnoreCase(
            String nome, String sobrenome, String descricao);
}

