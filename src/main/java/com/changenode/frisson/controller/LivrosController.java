package com.changenode.frisson.controller;

import com.changenode.frisson.model.Livros;
import com.changenode.frisson.query.LivrosQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public/cadastrar-livros")
public class LivrosController {
    @Autowired
    LivrosQuery entityQuery;
    @GetMapping
    public String formCadastro(final Model model) {
        Livros obj = new Livros();
        model.addAttribute("livro", obj);
        return "templates/formulario-livros";
    }

    @PostMapping
    public String formCadastro(@ModelAttribute(name="livro") final Livros obj) {
        entityQuery.save(obj);

        return "templates/confirmar-cadastro-de-livros";
    }
}
