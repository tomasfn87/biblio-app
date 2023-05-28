package com.changenode.frisson.controller;

import com.changenode.frisson.model.Editoras;
import com.changenode.frisson.query.EditorasQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/public/cadastrar-editoras")
public class EditorasController {
    @Autowired
    EditorasQuery entityQuery;
    @GetMapping
    public String formCadastro(final Model model) {
        Editoras obj = new Editoras();
        model.addAttribute("editora", obj);
        return "templates/formulario-editoras";
    }

    @PostMapping
    public String formCadastro(@ModelAttribute(name="editora") final Editoras obj) {
        entityQuery.save(obj);

        return "templates/confirmar-cadastro-de-editoras";
    }
}
