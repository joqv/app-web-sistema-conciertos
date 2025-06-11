package com.cibertec.app_web_reservas_conciertos.controller;

import com.cibertec.app_web_reservas_conciertos.entity.Reserva;
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

    @GetMapping("/list-reserva")
    private String listReserva(Model model) {

        model.addAttribute("reservaList", reservaService.getReservas());
        return "list-reserva";
    }

    @GetMapping("/view-reserva/{id}")
    private String viewReserva(Model model, @PathVariable Long id) throws Exception {

        Reserva reserva = reservaService.obtenerReserva(id);
        model.addAttribute("reserva", reserva);
        return "view-reserva";
    }

    @GetMapping("/new-reserva")
    private String newReserva(Model model) {
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("selectPalcos", palcoService.getPalcos());
        return "new-reserva";
    }
}
