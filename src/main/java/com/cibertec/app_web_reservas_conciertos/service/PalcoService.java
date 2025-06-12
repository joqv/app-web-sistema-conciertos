package com.cibertec.app_web_reservas_conciertos.service;

import com.cibertec.app_web_reservas_conciertos.entity.Palco;
import com.cibertec.app_web_reservas_conciertos.repository.PalcoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PalcoService {

    @Autowired
    PalcoRepository palcoRepository;

    public List<Palco> getPalcos() {

        return palcoRepository.findAll();
    }
}
