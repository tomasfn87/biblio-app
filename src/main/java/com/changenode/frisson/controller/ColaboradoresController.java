package com.changenode.frisson.controller;

import com.changenode.frisson.model.Colaboradores;
import com.changenode.frisson.query.ColaboradoresQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public/cadastrar-colaboradores")
public class ColaboradoresController {
    @Autowired
    ColaboradoresQuery entityQuery;
    @GetMapping
    public String formCadastro(final Model model) {
        Colaboradores obj = new Colaboradores();
        model.addAttribute("colaborador", obj);
        return "templates/formulario-colaboradores";
    }

    @PostMapping
    public String formCadastro(@ModelAttribute(name="colaborador") final Colaboradores obj) {
        entityQuery.save(obj);

        return "templates/confirmar-cadastro-de-colaboradores";
    }
}
