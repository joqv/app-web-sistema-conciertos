package com.cibertec.app_web_reservas_conciertos.service;

import com.cibertec.app_web_reservas_conciertos.entity.Reserva;
import com.cibertec.app_web_reservas_conciertos.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> getReservas() {
        return reservaRepository.findAll();
    }
}
