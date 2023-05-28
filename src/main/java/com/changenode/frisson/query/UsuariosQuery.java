package com.changenode.frisson.query;

import com.changenode.frisson.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosQuery extends JpaRepository<Usuarios, Long> {
}
