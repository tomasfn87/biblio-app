package com.changenode.frisson.query;

import com.changenode.frisson.model.Exemplares;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExemplaresQuery extends JpaRepository<Exemplares, Long> {
    List<Exemplares> findByExemplarCadastroContainingOrExemplarExclusaoContainingOrCondicoesContainingOrObservacoesContainingIgnoreCase(
            String exemplarCadastro,
            String exemplarExclusao,
            String condicoes,
            String observacoes);
}
