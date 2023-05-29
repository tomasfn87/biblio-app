package com.changenode.frisson.controller;

import com.changenode.frisson.model.Exemplares;
import com.changenode.frisson.query.ExemplaresQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/public/cadastrar-exemplares")
public class ExemplaresController {
    @Autowired
    ExemplaresQuery entityQuery;
    @GetMapping
    public String formCadastro(final Model model) {
        Exemplares obj = new Exemplares();
        model.addAttribute("exemplar", obj);
        return "templates/exemplares/formulario";
    }

    @PostMapping
    public String formCadastro(@ModelAttribute(name="exemplar") final Exemplares obj, HttpServletRequest request) {
        obj.setCondicoes(request.getParameter("estado"));
        entityQuery.save(obj);

        return "templates/exemplares/confirmar-cadastro";
    }
}
