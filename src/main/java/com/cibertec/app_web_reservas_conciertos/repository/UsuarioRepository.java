package com.cibertec.app_web_reservas_conciertos.repository;

import com.cibertec.app_web_reservas_conciertos.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmailAndPassword(String email, String password);
    Usuario findByEmail(String email);
    @Query(value = "CALL listarUsuariosActivos()", nativeQuery = true)
    List<Usuario> listarUsuariosActivos();

}
