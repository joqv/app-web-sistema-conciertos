package com.cibertec.app_web_reservas_conciertos.service;

import com.cibertec.app_web_reservas_conciertos.entity.Reserva;
import com.cibertec.app_web_reservas_conciertos.repository.ReservaRepository;
import com.cibertec.app_web_reservas_conciertos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    private UsuarioRepository usuarioRepository;

    public List<Reserva> getReservas() {

        return reservaRepository.findByActivo("ACTIVO");
    }

    public Reserva obtenerReserva(Long id) throws Exception {

        Optional<Reserva> reserva = reservaRepository.findById(id);
        if (reserva.isPresent()) {
            return reserva.get();
        } else {
            throw new Exception("Reserva no encontrada. ID: "+ id);
        }
    }

    public void agregarReserva(Reserva reserva) {

        reserva.setActivo("ACTIVO");
        reservaRepository.save(reserva);
    }

    public void actualizarReserva(Reserva reserva) {

        reserva.setActivo("ACTIVO");
        reservaRepository.save(reserva);
    }

    public void eliminarReserva(Long id) {

        try {
            Optional<Reserva> eReserva = reservaRepository.findById(id);
            if (eReserva.isPresent()) {
                eReserva.get().setActivo("INACTIVO");
                reservaRepository.save(eReserva.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
