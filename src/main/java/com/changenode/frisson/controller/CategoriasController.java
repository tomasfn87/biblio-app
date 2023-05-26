package com.changenode.frisson.controller;

import com.changenode.frisson.model.Categorias;
import com.changenode.frisson.query.CategoriasQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/public/cadastrar-categorias")
public class CategoriasController {
    @Autowired
    CategoriasQuery entityQuery;
    @GetMapping
    public String formCadastro(final Model model) {
        Categorias obj = new Categorias();
        model.addAttribute("categoria", obj);
        return "templates/formulario-categorias";
    }

    @PostMapping
    public String formCadastro(@ModelAttribute(name="categoria") final Categorias obj) {
        entityQuery.save(obj);

        return "templates/confirmar-cadastro-de-categorias";
    }
}
