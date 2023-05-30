package com.changenode.frisson.controller;

import com.changenode.frisson.model.Colaboradores;
import com.changenode.frisson.query.ColaboradoresQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ColaboradoresSearchController {

    @Autowired
    ColaboradoresQuery colaboradoresQuery;

    public List<Colaboradores> obterListaDeColaboradores() {
        return colaboradoresQuery.findAll();
    }

    public List<Colaboradores> obterBuscaPorColaborador(String termo) {
        Long cpf = null;
        if (isNumeric(termo)) {
            cpf = Long.valueOf(termo);
        }
        return colaboradoresQuery.
                findByCargoContainingIgnoreCaseOrNomeContainingIgnoreCaseOrCpfOrEnderecoContainingIgnoreCaseOrTelefoneContainingOrWhatsappContainingOrEmailContainingIgnoreCaseOrObservacaoContainingIgnoreCase(
                        termo,  // Cargo
                        termo,  // Nome
                        cpf,    // CPF
                        termo,  // Endereço
                        termo,  // Telefone
                        termo,  // WhatsApp
                        termo,  // Email
                        termo); // Observação
    }

    public static boolean isNumeric(String input) {
        try {
            Long.parseLong(input);
            return true;  // Successfully parsed as a long value
        } catch (NumberFormatException e) {
            try {
                Double.parseDouble(input);
                return true;  // Successfully parsed as a double value
            } catch (NumberFormatException ex) {
                return false;  // Cannot parse as either long or double
            }
        }
    }

    @GetMapping("/public/buscar-colaboradores")
    public String listarColaboradores(Model model) {
        model.addAttribute("buscaColaboradores", obterListaDeColaboradores());
        return "templates/colaboradores/busca";
    }

    @PostMapping("/public/buscar-colaboradores")
    public String buscarColaboradores(HttpServletRequest request, Model model) {
        model.addAttribute("buscaColaboradores", obterBuscaPorColaborador(request.getParameter("termo")));
        return "templates/colaboradores/busca";
    }
}