package com.cibertec.app_web_reservas_conciertos.service;

import com.cibertec.app_web_reservas_conciertos.entity.Reserva;
import com.cibertec.app_web_reservas_conciertos.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> getReservas() {
        return reservaRepository.findAll();
    }

    public Reserva obtenerReserva(Long id) throws Exception {

        Optional<Reserva> reserva = reservaRepository.findById(id);

        if (reserva.isPresent()) {
            return reserva.get();
        } else {
            throw new Exception("Reserva no encontrada. ID: "+ id);
        }
    }
}
