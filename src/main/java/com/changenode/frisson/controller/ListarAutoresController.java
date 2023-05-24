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
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/public/listarAutores")
public class ListarAutoresController {

    @Autowired
    AutoresEntityQuery autoresEntityQuery;

    @ModelAttribute("listaAutores")
    public List<Autores> obterListaDeAutores() {
        return autoresEntityQuery.findAll();
    }

    @GetMapping
    public String listarAutores(Model model) {
        List<Autores> listaDeAutores = obterListaDeAutores();
        model.addAttribute("listaAutores", listaDeAutores);
        return "templates/listarAutores";
    }
}
