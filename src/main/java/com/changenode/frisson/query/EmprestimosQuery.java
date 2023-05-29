package com.changenode.frisson.query;

import com.changenode.frisson.model.Emprestimos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmprestimosQuery extends JpaRepository<Emprestimos, Long> {
    List<Emprestimos> findByEmprestimoReservaContainingOrEmprestimoRetiradaContainingOrEmprestimoCancelamentoContainingOrObservacoesContainingIgnoreCase(
            String emprestimoReserva,
            String emprestimoRetirada,
            String emprestimoCancelamento,
            String observacoes);
}
