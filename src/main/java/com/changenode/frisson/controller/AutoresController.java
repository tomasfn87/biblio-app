package com.changenode.frisson.controller;

import com.changenode.frisson.model.Autores;
import com.changenode.frisson.query.AutoresQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/public/cadastrar-autores")
public class AutoresController {
    @Autowired
    AutoresQuery entityQuery;
    @GetMapping
    public String formCadastro(final Model model) {
        Autores obj = new Autores();
        obj.setId_autor(UUID.fromString("517d99fe-db7d-467e-b3f2-be5ac8c41752"));
        model.addAttribute("autor", obj);
        return "templates/autores/formulario";
    }

    @PostMapping
    public String formCadastro(@ModelAttribute(name="autor") final Autores obj) {
        entityQuery.save(obj);

        return "templates/autores/confirmar-cadastro";
    }
}
