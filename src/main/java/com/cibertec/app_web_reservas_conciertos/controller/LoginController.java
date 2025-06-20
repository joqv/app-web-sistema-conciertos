package com.cibertec.app_web_reservas_conciertos.controller;

import com.cibertec.app_web_reservas_conciertos.entity.Usuario;
import com.cibertec.app_web_reservas_conciertos.repository.UsuarioRepository;
import com.cibertec.app_web_reservas_conciertos.service.PalcoService;
import com.cibertec.app_web_reservas_conciertos.service.ReservaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @Autowired
    private PalcoService palcoService;

    @Autowired
    private ReservaService reservaService;




    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/")
    public String mostrarLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        Usuario usuario = usuarioRepository.findByEmailAndPassword(email, password);

        if (usuario != null) {
            session.setAttribute("usuarioLogueado", usuario.getNombreUsuario());
            session.setAttribute("rolUsuario", usuario.getRol());

            if ("ADMINISTRADOR".equals(usuario.getRol())) {
                return "redirect:/inicio";
            } else {
                return "redirect:/usuario/inicio";
            }
        } else {
            model.addAttribute("error", true);
            return "login";
        }
    }





    @GetMapping("/inicio")
    public String mostrarMenu(HttpSession session, Model model) {
        long totalUsuarios = usuarioRepository.count();
        long totalPalcos = palcoService.getPalcos().size();
        long totalReservas = reservaService.getReservas().size();

        model.addAttribute("usuarioLogueado", session.getAttribute("usuarioLogueado"));
        model.addAttribute("totalUsuarios", totalUsuarios);
        model.addAttribute("totalPalcos", totalPalcos);
        model.addAttribute("totalReservas", totalReservas);

        return "index";
    }


}
