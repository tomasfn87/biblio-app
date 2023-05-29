package com.changenode.frisson.query;

import com.changenode.frisson.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuariosQuery extends JpaRepository<Usuarios, Long> {
    List<Usuarios> findByNomeContainingIgnoreCaseOrCpfContainingOrEnderecoContainingIgnoreCaseOrTelefoneContainingIgnoreCaseOrWhatsappContainingIgnoreCaseOrEmailContainingIgnoreCaseOrObservacaoContainingIgnoreCase(
            String nome,
            String cpf,
            String endereco,
            String telefone,
            String whatsapp,
            String email,
            String observacao);
}
