package com.cibertec.app_web_reservas_conciertos.controller;

import com.cibertec.app_web_reservas_conciertos.entity.Reserva;
import com.cibertec.app_web_reservas_conciertos.repository.UsuarioRepository;
import com.cibertec.app_web_reservas_conciertos.service.PalcoService;
import com.cibertec.app_web_reservas_conciertos.service.ReservaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private PalcoService palcoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/listar-reserva")
    private String listReserva( HttpSession session, Model model) {

        String rol = (String) session.getAttribute("rolUsuario");

        if (rol == null || !rol.equals("ADMINISTRADOR")) {
            return "redirect:/";
        }

        model.addAttribute("reservaList", reservaService.getReservas());
        model.addAttribute("usuarioLogueado", session.getAttribute("usuarioLogueado"));
        return "listar-reserva";
    }

    @GetMapping("/ver-reserva/{id}")
    private String viewReserva(HttpSession session,Model model, @PathVariable Long id) throws Exception {

        String rol = (String) session.getAttribute("rolUsuario");

        if (rol == null || !rol.equals("ADMINISTRADOR")) {
            return "redirect:/";
        }

        Reserva reserva = reservaService.obtenerReserva(id);
        model.addAttribute("reserva", reserva);
        model.addAttribute("usuarioLogueado", session.getAttribute("usuarioLogueado"));
        return "ver-reserva";
    }

    @GetMapping("/nueva-reserva")
    private String newReserva(HttpSession session, Model model) {

        String rol = (String) session.getAttribute("rolUsuario");

        if (rol == null || !rol.equals("ADMINISTRADOR")) {
            return "redirect:/";
        }

        model.addAttribute("reserva", new Reserva());
        model.addAttribute("selectPalcos", palcoService.getPalcos());
        model.addAttribute("usuarioLogueado", session.getAttribute("usuarioLogueado"));
        model.addAttribute("selectUsuarios", usuarioRepository.listarUsuariosActivos());
        return "nueva-reserva";
    }

    @GetMapping("/editar-reserva/{id}")
    private String editarReserva(HttpSession session, @PathVariable Long id, Model model) throws Exception {

        String rol = (String) session.getAttribute("rolUsuario");

        if (rol == null || !rol.equals("ADMINISTRADOR")) {
            return "redirect:/";
        }

        Reserva reserva = reservaService.obtenerReserva(id);

        model.addAttribute("reserva", reserva);
        model.addAttribute("selectPalcos", palcoService.getPalcos());
        model.addAttribute("selectUsuarios", usuarioRepository.listarUsuariosActivos());
        model.addAttribute("usuarioLogueado", session.getAttribute("usuarioLogueado"));
        return "editar-reserva";
    }

    @PostMapping("/agregar-reserva")
    private String agregarReserva(HttpSession session,@ModelAttribute Reserva reserva) {

        String rol = (String) session.getAttribute("rolUsuario");

        if (rol == null || !rol.equals("ADMINISTRADOR")) {
            return "redirect:/";
        }

        reservaService.agregarReserva(reserva);
        return "redirect:/listar-reserva";
    }

    @PostMapping("/actualizar-reserva")
    private String actualizarReserva(HttpSession session, @ModelAttribute Reserva reserva) {

        String rol = (String) session.getAttribute("rolUsuario");

        if (rol == null || !rol.equals("ADMINISTRADOR")) {
            return "redirect:/";
        }

        System.out.println("Reserva: "+ reserva);
        reservaService.actualizarReserva(reserva);
        return "redirect:/listar-reserva";
    }

    @GetMapping("/eliminar-reserva/{id}")
    private String eliminarReserva(HttpSession session,@PathVariable Long id) {

        String rol = (String) session.getAttribute("rolUsuario");

        if (rol == null || !rol.equals("ADMINISTRADOR")) {
            return "redirect:/";
        }

        reservaService.eliminarReserva(id);

        return "redirect:/listar-reserva";
    }
}
