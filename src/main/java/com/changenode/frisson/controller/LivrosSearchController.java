package com.changenode.frisson.controller;

import com.changenode.frisson.model.Livros;
import com.changenode.frisson.query.LivrosQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LivrosSearchController {

    @Autowired
    LivrosQuery livrosQuery;

    public List<Livros> obterListaDeLivros() {
        return livrosQuery.findAll();
    }

    public List<Livros> obterBuscaPorLivro(String termo) {
        return livrosQuery.
                findByIsbnContainingIgnoreCaseOrTituloContainingIgnoreCaseOrAnoContainingOrEdicaoContainingOrAssuntosContainingIgnoreCaseOrPalavrasChavesContainingIgnoreCaseOrObservacoesContainingIgnoreCase(
                        termo, termo, termo, termo,
                        termo, termo, termo);
    }

    @GetMapping("/public/buscar-livros")
    public String listarLivros(Model model) {
        model.addAttribute("buscaLivros", obterListaDeLivros());
        return "templates/livros/busca";
    }

    @PostMapping("/public/buscar-livros")
    public String buscarLivros(HttpServletRequest request, Model model) {
        model.addAttribute("buscaLivros", obterBuscaPorLivro(request.getParameter("termo")));
        return "templates/livros/busca";
    }
}