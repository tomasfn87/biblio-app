package com.changenode.frisson.controller;

import com.changenode.frisson.model.Exemplares;
import com.changenode.frisson.query.ExemplaresQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ExemplaresSearchController {

    @Autowired
    ExemplaresQuery exemplaresQuery;

    public List<Exemplares> obterListaDeExemplares() {
        return exemplaresQuery.findAll();
    }

    public List<Exemplares> obterBuscaPorExemplar(String termo) {
        return exemplaresQuery.
                findByExemplarCadastroContainingOrExemplarExclusaoContainingOrCondicoesContainingOrObservacoesContainingIgnoreCase(
                        termo, termo, termo, termo);
    }

    @GetMapping("/public/buscar-exemplares")
    public String listarExemplares(Model model) {
        model.addAttribute("buscaExemplares", obterListaDeExemplares());
        return "templates/exemplares/busca";
    }

    @PostMapping("/public/buscar-exemplares")
    public String buscarExemplares(HttpServletRequest request, Model model) {
        model.addAttribute("buscaExemplares", obterBuscaPorExemplar(request.getParameter("termo")));
        return "templates/exemplares/busca";
    }
}