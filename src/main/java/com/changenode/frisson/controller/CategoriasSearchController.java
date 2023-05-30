package com.changenode.frisson.controller;

import com.changenode.frisson.model.Categorias;
import com.changenode.frisson.query.CategoriasQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CategoriasSearchController {

    @Autowired
    CategoriasQuery categoriasQuery;

    public List<Categorias> obterListaDeCategorias() {
        return categoriasQuery.findAll();
    }

    public List<Categorias> obterBuscaPorCategoria(String termo) {
        return categoriasQuery.
                findByDescricaoContainingIgnoreCase(termo);
    }

    @GetMapping("/public/buscar-categorias")
    public String listarCategorias(Model model) {
        model.addAttribute("buscaCategorias", obterListaDeCategorias());
        return "templates/categorias/busca";
    }

    @PostMapping("/public/buscar-categorias")
    public String buscarCategorias(HttpServletRequest request, Model model) {
        model.addAttribute("buscaCategorias", obterBuscaPorCategoria(request.getParameter("termo")));
        return "templates/categorias/busca";
    }
}