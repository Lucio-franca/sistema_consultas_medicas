package com.consultoriomedico.sistema.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.consultoriomedico.sistema.model.Medico;
import com.consultoriomedico.sistema.service.MedicoService;

@RestController
@RequestMapping("/medicos")
@CrossOrigin("*")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping("/todos")
    public List<Medico> listar() {
        return medicoService.findAll();
    }

    @GetMapping("/{id}")
    public Medico buscarPorId(@PathVariable Long id) {
        return medicoService.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Medico salvar(@RequestBody Medico medico) {
        return medicoService.save(medico);
    }

    @PutMapping("/{id}")
    public Medico atualizar(@PathVariable Long id, @RequestBody Medico novo) {
        return medicoService.update(id, novo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        medicoService.deleteById(id);
    }
}
