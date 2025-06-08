package com.cibertec.app_web_reservas_conciertos.repository;

import com.cibertec.app_web_reservas_conciertos.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
