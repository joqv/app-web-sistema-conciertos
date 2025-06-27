package com.cibertec.app_web_reservas_conciertos.controller;

import com.cibertec.app_web_reservas_conciertos.entity.Palco;
import com.cibertec.app_web_reservas_conciertos.service.PalcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("")
public class PalcoController {

    @Autowired
    private PalcoService palcoService;

    // Listar todos os palcos
    @GetMapping("/list-palco")
    public String listarPalcos(Model model) {
        List<Palco> lista = palcoService.getPalcos();
        model.addAttribute("palcoList", lista);
        return "list-palco"; // Nome do template HTML
    }

    // Ver detalhes
    @GetMapping("/view/{id}")
    public String verPalco(@PathVariable Long id, Model model) throws Exception {
        Palco palco = palcoService.getPalco(id);
        model.addAttribute("palco", palco);
        return "view-palco"; // Crie esse template se quiser visualizar 1 item
    }

    // Formulário de edição
    @GetMapping("/edit/{id}")
    public String editarPalco(@PathVariable Long id, Model model) throws Exception {
        Palco palco = palcoService.getPalco(id);
        model.addAttribute("palco", palco);
        return "edit-palco"; // Página com formulário para editar
    }

    // Salvar alterações
    @PostMapping("/update")
    public String atualizarPalco(@ModelAttribute Palco palco) throws Exception {
        palcoService.updatePalco(palco);
        return "redirect:/list-palco";
    }

    // Remover palco
    @GetMapping("/remove/{id}")
    public String removerPalco(@PathVariable Long id, RedirectAttributes redirectAttrs) {
        boolean fueDesactivado = palcoService.deletePalco(id);

        if (!fueDesactivado) {
            redirectAttrs.addFlashAttribute("error", "No se puede desactivar el palco: tiene reservas activas.");
        } else {
            redirectAttrs.addFlashAttribute("mensaje", "Palco desactivado correctamente.");
        }

        return "redirect:/list-palco";
    }


    // Formulário de criação
    @GetMapping("/nuevo")
    public String nuevoPalco(Model model) {
        model.addAttribute("palco", new Palco());
        return "new-palco"; // Template com formulário para novo palco
    }

    // Gravar novo palco
    @PostMapping("/add")
    public String guardarPalco(@ModelAttribute Palco palco) throws Exception {
        palcoService.addPalco(palco);
        return "redirect:/list-palco";
    }
}

