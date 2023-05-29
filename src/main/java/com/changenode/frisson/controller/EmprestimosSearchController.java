package com.changenode.frisson.controller;

import com.changenode.frisson.model.Emprestimos;
import com.changenode.frisson.query.EmprestimosQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class EmprestimosSearchController {

    @Autowired
    EmprestimosQuery emprestimosQuery;

    public List<Emprestimos> obterListaDeEmprestimos() {
        return emprestimosQuery.findAll();
    }

    public List<Emprestimos> obterBuscaPorEmprestimo(String termo) {
        return emprestimosQuery.
                findByEmprestimoReservaContainingOrEmprestimoRetiradaContainingOrEmprestimoCancelamentoContainingOrObservacoesContainingIgnoreCase(
                        termo, termo, termo, termo);
    }

    @GetMapping("/public/buscar-emprestimos")
    public String listarEmprestimos(Model model) {
        model.addAttribute("buscaEmprestimos", obterListaDeEmprestimos());
        return "templates/emprestimos/busca";
    }

    @PostMapping("/public/buscar-emprestimos")
    public String buscarEmprestimos(HttpServletRequest request, Model model) {
        model.addAttribute("buscaEmprestimos", obterBuscaPorEmprestimo(request.getParameter("termo")));
        return "templates/emprestimos/busca";
    }
}