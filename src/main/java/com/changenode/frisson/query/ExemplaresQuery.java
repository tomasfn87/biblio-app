package com.changenode.frisson.query;

import com.changenode.frisson.model.Exemplares;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExemplaresQuery extends JpaRepository<Exemplares, Long> {
}
