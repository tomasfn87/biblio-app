package com.changenode.frisson.controller;

import com.changenode.frisson.model.Editoras;
import com.changenode.frisson.query.EditorasQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class EditorasSearchController {

    @Autowired
    EditorasQuery editorasQuery;

    public List<Editoras> obterListaDeEditoras() {
        return editorasQuery.findAll();
    }

    public List<Editoras> obterBuscaPorEditora(String termo) {
        return editorasQuery.findByNomeContainingIgnoreCase(termo);
    }

    @GetMapping("/public/buscar-editoras")
    public String listarEditoras(Model model) {
        model.addAttribute("buscaEditoras", obterListaDeEditoras());
        return "templates/editoras/busca";
    }

    @PostMapping("/public/buscar-editoras")
    public String buscarEditoras(HttpServletRequest request, Model model) {
        model.addAttribute("buscaEditoras", obterBuscaPorEditora(request.getParameter("termo")));
        return "templates/editoras/busca";
    }
}