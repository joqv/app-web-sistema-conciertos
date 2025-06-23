package com.cibertec.app_web_reservas_conciertos.repository;

import com.cibertec.app_web_reservas_conciertos.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    public List<Reserva> findByActivo(String activo);
}
