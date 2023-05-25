package com.changenode.frisson.query;

import com.changenode.frisson.model.Emprestimos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimosQuery extends JpaRepository<Emprestimos, Long> {
}
