package com.cibertec.app_web_reservas_conciertos.controller;

import com.cibertec.app_web_reservas_conciertos.entity.Usuario;
import com.cibertec.app_web_reservas_conciertos.repository.RolRepository;
import com.cibertec.app_web_reservas_conciertos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/register")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles", rolRepository.findAll());
        return "register";
    }

    @PostMapping("/register")
    public String registrarUsuario(@ModelAttribute Usuario usuario, Model model) {
        // Validar si el email ya existe
        if (usuarioRepository.findByEmail(usuario.getEmail()) != null) {
            model.addAttribute("error", "Ya existe un usuario con ese correo.");
            return "register";
        }
        usuario.setEstado("ACTIVO");

        usuarioRepository.save(usuario);
        return "redirect:/";
    }
}
