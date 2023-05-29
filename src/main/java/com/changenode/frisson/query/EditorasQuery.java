package com.changenode.frisson.query;

import com.changenode.frisson.model.Editoras;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EditorasQuery extends JpaRepository<Editoras, Long> {
    List<Editoras> findByNomeContainingIgnoreCase(String nome);
}
