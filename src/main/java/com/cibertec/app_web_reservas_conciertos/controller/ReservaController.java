package com.cibertec.app_web_reservas_conciertos.controller;

import com.cibertec.app_web_reservas_conciertos.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping("list-reserva")
    private String listReserva(Model model) {

        model.addAttribute("reservaList", reservaService.getReservas());
        return "list-reserva";
    }
}
