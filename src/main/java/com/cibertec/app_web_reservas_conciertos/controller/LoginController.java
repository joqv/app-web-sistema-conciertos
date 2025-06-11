package com.cibertec.app_web_reservas_conciertos.controller;

import com.cibertec.app_web_reservas_conciertos.entity.Usuario;
import com.cibertec.app_web_reservas_conciertos.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Mostrar el formulario de login
    @GetMapping("/")
    public String mostrarLogin() {
        return "login";
    }

    // Procesar el login
    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        Usuario usuario = usuarioRepository.findByEmailAndPassword(email, password);

        if (usuario != null) {
            // Guardar nombre y rol en sesión
            session.setAttribute("usuarioLogueado", usuario.getNombreUsuario());
            session.setAttribute("rolUsuario", usuario.getRol());

            if ("ADMINISTRADOR".equals(usuario.getRol())) {
                return "redirect:/inicio"; // vista del admin
            } else {
                return "redirect:/usuario/inicio"; // vista del usuario
            }
        } else {
            model.addAttribute("error", true);
            return "login";
        }
    }

    // Mostrar el menú del administrador
    @GetMapping("/inicio")
    public String mostrarMenu() {
        return "index";
    }
}
