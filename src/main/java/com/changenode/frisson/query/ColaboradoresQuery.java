package com.changenode.frisson.query;

import com.changenode.frisson.model.Colaboradores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColaboradoresQuery extends JpaRepository<Colaboradores, Long> {
    List<Colaboradores> findByCargoContainingIgnoreCaseOrNomeContainingIgnoreCaseOrCpfOrEnderecoContainingIgnoreCaseOrTelefoneContainingOrWhatsappContainingOrEmailContainingIgnoreCaseOrObservacaoContainingIgnoreCase(
            String cargo,
            String nome,
            Long cpf,
            String endereco,
            String telefone,
            String whatsapp,
            String email,
            String observacao);
}
