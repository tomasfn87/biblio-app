package com.changenode.frisson.controller;

import com.changenode.frisson.model.Autores;
import com.changenode.frisson.query.AutoresEntityQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class ListarAutoresController {

    @Autowired
    AutoresEntityQuery autoresEntityQuery;

    public List<Autores> obterListaDeAutores() {
        return autoresEntityQuery.findAll();
    }

    public List<Autores> obterBuscaPorAutor(String termo) {
        return autoresEntityQuery.findByNomeOrSobrenomeOrDescricao(termo, termo, termo);
    }

    @RequestMapping(value = "/public/listarAutores", method = GET)
    public String listarAutores(Model model) {
        model.addAttribute("listaAutores", obterListaDeAutores());
        return "templates/listarAutores";
    }

    @RequestMapping(value = "/public/listarAutores", method = POST)
    public String buscarAutores(HttpServletRequest request, Model model) {
        model.addAttribute("listaAutores", obterBuscaPorAutor(request.getParameter("termo")));
        return "templates/listarAutores";
    }
}
