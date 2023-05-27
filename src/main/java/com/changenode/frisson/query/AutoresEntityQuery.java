package com.changenode.frisson.query;

import com.changenode.frisson.model.Autores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutoresEntityQuery extends JpaRepository<Autores, Long> {
    List<Autores> findByNomeOrSobrenomeOrDescricao(String nome, String sobrenome, String descricao);
}