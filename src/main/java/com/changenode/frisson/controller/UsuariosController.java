package com.changenode.frisson.controller;

import com.changenode.frisson.model.Usuarios;
import com.changenode.frisson.query.UsuariosQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public/cadastrar-usuarios")
public class UsuariosController {
    @Autowired
    UsuariosQuery entityQuery;
    @GetMapping
    public String formCadastro(final Model model) {
        Usuarios obj = new Usuarios();
        model.addAttribute("usuario", obj);
        return "templates/usuarios/formulario";
    }

    @PostMapping
    public String formCadastro(@ModelAttribute(name="usuario") final Usuarios obj) {
        entityQuery.save(obj);

        return "templates/usuarios/confirmar-cadastro";
    }
}
