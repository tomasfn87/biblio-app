package com.changenode.frisson.controller;

import com.changenode.frisson.model.Autores;
import com.changenode.frisson.query.AutoresEntityQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/public/cadastrarAutores")
public class FormController {

    @Autowired
    AutoresEntityQuery autoresEntityQuery;

    @GetMapping
    public String formAutores(final Model model) {
        Autores autor = new Autores();
        autor.setId_autor(UUID.fromString("517d99fe-db7d-467e-b3f2-be5ac8c41752"));
        model.addAttribute("autor", autor);
        return "templates/formAutores";
    }

    @PostMapping
    public String formAutores(@ModelAttribute(name="autor") final Autores autor) {

        autoresEntityQuery.save(autor); //ERRO: Problema com Hibernate

        return "templates/confirmCadastroAutores";
    }
}
