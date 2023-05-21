package com.changenode.frisson.query;

import com.changenode.frisson.model.Autores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoresEntityQuery extends JpaRepository<Autores, Long> {
}