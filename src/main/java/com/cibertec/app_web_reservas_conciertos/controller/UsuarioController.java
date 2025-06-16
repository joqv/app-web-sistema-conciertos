package com.cibertec.app_web_reservas_conciertos.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

    @GetMapping("/usuario/inicio")
    public String inicioUsuario(HttpSession session, Model model) {
        String nombre = (String) session.getAttribute("usuarioLogueado");
        model.addAttribute("usuarioLogueado", nombre);
        return "usuario-inicio";
    }
}
