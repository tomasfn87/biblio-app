package com.changenode.frisson.controller;

import com.changenode.frisson.model.Usuarios;
import com.changenode.frisson.query.UsuariosQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UsuariosSearchController {

    @Autowired
    UsuariosQuery usuariosQuery;

    public List<Usuarios> obterListaDeUsuarios() {
        return usuariosQuery.findAll();
    }

    public List<Usuarios> obterBuscaPorUsuario(String termo) {
        return usuariosQuery.
                findByNomeContainingIgnoreCaseOrCpfContainingOrEnderecoContainingIgnoreCaseOrTelefoneContainingIgnoreCaseOrWhatsappContainingIgnoreCaseOrEmailContainingIgnoreCaseOrObservacaoContainingIgnoreCase(
                        termo, termo, termo, termo,
                        termo, termo, termo);
    }

    @GetMapping("/public/buscar-usuarios")
    public String listarLivros(Model model) {
        model.addAttribute("buscaUsuarios", obterListaDeUsuarios());
        return "templates/usuarios/busca";
    }

    @PostMapping("/public/buscar-usuarios")
    public String buscarLivros(HttpServletRequest request, Model model) {
        model.addAttribute("buscaUsuarios", obterBuscaPorUsuario(request.getParameter("termo")));
        return "templates/usuarios/busca";
    }
}