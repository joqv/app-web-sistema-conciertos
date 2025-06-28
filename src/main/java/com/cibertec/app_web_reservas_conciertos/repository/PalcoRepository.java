package com.cibertec.app_web_reservas_conciertos.repository;

import com.cibertec.app_web_reservas_conciertos.entity.Palco;
import com.cibertec.app_web_reservas_conciertos.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PalcoRepository extends JpaRepository<Palco, Long> {

    @Query(value = "CALL listarPalcosActivos()", nativeQuery = true)
    List<Palco> listarPalcosActivos();




}
