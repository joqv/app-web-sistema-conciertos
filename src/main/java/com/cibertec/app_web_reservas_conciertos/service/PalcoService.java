package com.cibertec.app_web_reservas_conciertos.service;

import com.cibertec.app_web_reservas_conciertos.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.cibertec.app_web_reservas_conciertos.entity.Palco;
import com.cibertec.app_web_reservas_conciertos.repository.PalcoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;



import java.util.List;
import java.util.Optional;

@Service
public class PalcoService {

    @Autowired
    private PalcoRepository palcoRepository;
    @Autowired
    private ReservaRepository reservaRepository;

    @Transactional(readOnly = true)
    public List<Palco> getPalcos() {

        //return palcoRepository.findAll();
        return palcoRepository.listarPalcosActivos();
    }

    public Palco getPalco(Long idPalco) throws Exception {
        Optional<Palco> opt = palcoRepository.findById(idPalco);
        if (opt.isEmpty()) {
            throw new Exception("O palco com ID " + idPalco + " não foi encontrado.");
        }
        return opt.get();
    }

    public void addPalco(Palco palco) throws Exception {
        if (!StringUtils.hasText(palco.getNombrePalco())) {
            throw new Exception("O nome do palco é obrigatório.");
        }
        if (palco.getAforo() == null || palco.getAforo() <= 0) {
            throw new Exception("O aforo deve ser um valor positivo.");
        }
        if (!StringUtils.hasText(palco.getUbicacion())) {
            throw new Exception("A localização do palco é obrigatória.");
        }

        palcoRepository.save(palco);
    }

    public void updatePalco(Palco palco) throws Exception {
        Palco existente = getPalco(palco.getIdPalco());

        if (!StringUtils.hasText(palco.getNombrePalco())) {
            throw new Exception("O nome do palco é obrigatório.");
        }
        if (palco.getAforo() == null || palco.getAforo() <= 0) {
            throw new Exception("O aforo deve ser um valor positivo.");
        }
        if (!StringUtils.hasText(palco.getUbicacion())) {
            throw new Exception("A localização do palco é obrigatória.");
        }

        existente.setNombrePalco(palco.getNombrePalco());
        existente.setAforo(palco.getAforo());
        existente.setUbicacion(palco.getUbicacion());

        palcoRepository.save(existente);
    }

   // public void deletePalco(Long idPalco) throws Exception {
     //   Palco palco = getPalco(idPalco);
    //    palcoRepository.delete(palco);
    //}
   public boolean deletePalco(long id) {
       boolean tieneReservasActivas = reservaRepository.existsByPalco_IdPalcoAndActivo((int) id, "ACTIVO");

       if (tieneReservasActivas) {
           return false;
       }

       Optional<Palco> optionalPalco = palcoRepository.findById(id);
       if (optionalPalco.isPresent()) {
           Palco palco = optionalPalco.get();
           palco.setEstado("DESACTIVADO");
           palcoRepository.save(palco);
       }
        return true;
   }

}
