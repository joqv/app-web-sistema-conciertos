package com.cibertec.app_web_reservas_conciertos.controller;

import com.cibertec.app_web_reservas_conciertos.entity.Usuario;
import com.cibertec.app_web_reservas_conciertos.repository.RolRepository;
import com.cibertec.app_web_reservas_conciertos.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/admin/usuarios")
    public String listarUsuarios(HttpSession session, Model model) {
        System.out.println("🔍 Entrando a /admin/usuarios");

        String rol = (String) session.getAttribute("rolUsuario");
        System.out.println("👉 rolUsuario en sesión: " + rol);

        if (rol == null || !rol.equals("ADMINISTRADOR")) {
            System.out.println("❌ Rol nulo o no ADMINISTRADOR. Redirigiendo a /acceso-denegado");
            return "redirect:/";
        }

        String nombreUsuario = (String) session.getAttribute("usuarioLogueado");
        System.out.println("👤 usuarioLogueado en sesión: " + nombreUsuario);
        model.addAttribute("usuarioLogueado", nombreUsuario);

        List<Usuario> usuariosActivos = usuarioRepository.listarUsuariosActivos();
        System.out.println("✅ Usuarios activos encontrados: " + usuariosActivos.size());
        model.addAttribute("usuarios", usuariosActivos);
        return "usuarios-list";
    }

    @GetMapping("/admin/usuarios/desactivar/{id}")
    public String desactivarUsuario(HttpSession session, @PathVariable Long id) {

        String rol = (String) session.getAttribute("rolUsuario");

        if (rol == null || !rol.equals("ADMINISTRADOR")) {
            return "redirect:/";
        }

        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            usuario.setEstado("INACTIVO");
            usuarioRepository.save(usuario);
        }
        return "redirect:/admin/usuarios";
    }

    @GetMapping("/admin/usuarios/new")
    public String mostrarFormularioRegistro(HttpSession session, Model model) {

        String rol = (String) session.getAttribute("rolUsuario");

        if (rol == null || !rol.equals("ADMINISTRADOR")) {
            return "redirect:/";
        }

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles", rolRepository.findAll());
        model.addAttribute("titulo", "Registrar Nuevo Usuario");
        return "usuarios-form";
    }

    @GetMapping("/admin/usuarios/edit/{id}")
    public String mostrarFormularioEdicion(HttpSession session, @PathVariable Long id, Model model) {

        String rol = (String) session.getAttribute("rolUsuario");

        if (rol == null || !rol.equals("ADMINISTRADOR")) {
            return "redirect:/";
        }

        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario == null) {
            return "redirect:/admin/usuarios";
        }
        model.addAttribute("usuario", usuario);
        model.addAttribute("roles", rolRepository.findAll());
        model.addAttribute("titulo", "Editar Usuario");
        return "usuarios-form";
    }

    @PostMapping("/admin/usuarios/save")
    public String guardarUsuario(HttpSession session, @ModelAttribute Usuario usuario) {

        String rol = (String) session.getAttribute("rolUsuario");

        if (rol == null || !rol.equals("ADMINISTRADOR")) {
            return "redirect:/";
        }

        if (usuario.getIdUsuario() == null) {
            usuario.setEstado("ACTIVO");
        } else {
            Usuario original = usuarioRepository.findById(usuario.getIdUsuario()).orElse(null);
            if (original != null) {
                usuario.setEstado(original.getEstado());
            }
        }
        usuarioRepository.save(usuario);
        return "redirect:/admin/usuarios";
    }
}


