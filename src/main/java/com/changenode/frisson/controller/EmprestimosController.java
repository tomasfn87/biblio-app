package com.changenode.frisson.controller;

import com.changenode.frisson.model.Emprestimos;
import com.changenode.frisson.query.EmprestimosQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public/cadastrar-emprestimos")
public class EmprestimosController {
    @Autowired
    EmprestimosQuery entityQuery;
    @GetMapping
    public String formCadastro(final Model model) {
        Emprestimos obj = new Emprestimos();
        model.addAttribute("emprestimo", obj);
        return "templates/emprestimos/formulario";
    }

    @PostMapping
    public String formCadastro(@ModelAttribute(name="emprestimo") final Emprestimos obj) {
        entityQuery.save(obj);

        return "templates/emprestimos/confirmar-cadastro";
    }
}
