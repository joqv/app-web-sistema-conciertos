package com.cibertec.app_web_reservas_conciertos.controller;

import com.cibertec.app_web_reservas_conciertos.entity.Reserva;
import com.cibertec.app_web_reservas_conciertos.service.PdfGeneradorService;
import com.cibertec.app_web_reservas_conciertos.service.ReservaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private PdfGeneradorService pdfGeneradorService;

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/lista-reservas-pdf")
    public ResponseEntity<byte[]> generateReservasPdf(HttpSession session) throws IOException {

        String rol = (String) session.getAttribute("rolUsuario");

        if (rol == null || !rol.equals("ADMINISTRADOR")) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", "/");
            return new ResponseEntity<>(headers, HttpStatus.FOUND);
        }

        List<Reserva> listReserva = reservaService.getReservas();

        Map<String, Object> data = new HashMap<>();
        data.put("reservas", listReserva);

        byte[] pdfBytes = pdfGeneradorService.generatePdfFromHtml("reporte-listado-reserva", data);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=lista_reservas.pdf");
        headers.setContentType(MediaType.APPLICATION_PDF);

        return ResponseEntity.ok().headers(headers).body(pdfBytes);
    }
}
