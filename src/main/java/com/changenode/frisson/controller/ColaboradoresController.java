package com.changenode.frisson.controller;

import com.changenode.frisson.classes.Enderecos;
import com.changenode.frisson.model.Colaboradores;
import com.changenode.frisson.query.ColaboradoresQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/public/cadastrar-colaboradores")
public class ColaboradoresController {
    @Autowired
    ColaboradoresQuery entityQuery;
    @GetMapping
    public String formCadastro(final Model model) {
        Colaboradores obj = new Colaboradores();
        model.addAttribute("colaborador", obj);
        return "templates/colaboradores/formulario";
    }

    @PostMapping
    public String formCadastro(@ModelAttribute(name="colaborador") final Colaboradores obj, HttpServletRequest request) {
        String inputEndereco = String.join("; ",
                request.getParameter("tipo"),
                request.getParameter("logradouro"),
                request.getParameter("numero"),
                request.getParameter("complemento"),
                request.getParameter("bairro"),
                request.getParameter("cidade"),
                request.getParameter("estado"),
                request.getParameter("cep"));
        Enderecos endereco = new Enderecos(inputEndereco);
        obj.setEndereco(endereco.toString());
        entityQuery.save(obj);

        return "templates/colaboradores/confirmar-cadastro";
    }
}
