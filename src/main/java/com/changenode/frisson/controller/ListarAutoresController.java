package com.changenode.frisson.controller;

import com.changenode.frisson.model.Autores;
import com.changenode.frisson.query.AutoresEntityQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class ListarAutoresController {

    @Autowired
    AutoresEntityQuery autoresEntityQuery;

    @ModelAttribute("listaAutores")
    public List<Autores> obterListaDeAutores() {
        return autoresEntityQuery.findAll();
    }

    @ModelAttribute("buscaAutores")
    public List<Autores> obterBuscaPorAutor(@RequestParam(value = "termo", required = false) String termo) {
        return autoresEntityQuery.findByNomeOrSobrenomeOrDescricao(termo, termo, termo);
    }

    @RequestMapping(value = "/public/listarAutores", method = GET)
    public String listarAutores(Model model) {
        List<Autores> listaDeAutores = obterListaDeAutores();
        model.addAttribute("listaAutores", listaDeAutores);
        return "templates/listarAutores";
    }

    @RequestMapping(value = "/public/buscarAutores", method = POST)
    public String buscarAutores(@ModelAttribute(name="termo") String termo, Model model) {
        List<Autores> resultadoBusca;
        if (termo != null && !termo.isEmpty()) {
            resultadoBusca = obterBuscaPorAutor(termo);
        } else {
            resultadoBusca = Collections.emptyList(); // Trazer uma lista vazia caso não exista uma valor para 'termo'
        }
        model.addAttribute("buscaAutores", resultadoBusca);
        return "templates/buscarAutores";
    }
}
