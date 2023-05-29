package com.changenode.frisson.controller;

import com.changenode.frisson.model.Autores;
import com.changenode.frisson.query.AutoresQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AutoresSearchController {

    @Autowired
    AutoresQuery autoresQuery;

    public List<Autores> obterListaDeAutores() {
        return autoresQuery.findAll();
    }

    public List<Autores> obterBuscaPorAutor(String termo) {
        return autoresQuery.
                findByNomeContainingIgnoreCaseOrSobrenomeContainingIgnoreCaseOrDescricaoContainingIgnoreCase(
                        termo, termo, termo);
    }

    @GetMapping("/public/buscar-autores")
    public String listarAutores(Model model) {
        model.addAttribute("buscaAutores", obterListaDeAutores());
        return "templates/autores/busca";
    }

    @PostMapping("/public/buscar-autores")
    public String buscarAutores(HttpServletRequest request, Model model) {
        model.addAttribute("buscaAutores", obterBuscaPorAutor(request.getParameter("termo")));
        return "templates/autores/busca";
    }
}