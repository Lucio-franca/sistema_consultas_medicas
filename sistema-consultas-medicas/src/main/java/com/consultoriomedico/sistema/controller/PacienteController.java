package com.consultoriomedico.sistema.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.consultoriomedico.sistema.model.Paciente;
import com.consultoriomedico.sistema.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin("*")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/todos")
    public List<Paciente> listar() {
        return pacienteService.findAll();
    }

    @GetMapping("/{id}")
    public Paciente buscarPorId(@PathVariable long id) {
        return pacienteService.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Paciente salvar(@RequestBody Paciente paciente) {
        return pacienteService.save(paciente);
    }

    @PutMapping("/{id}")
    public Paciente atualizar(@PathVariable Long id, @RequestBody Paciente novo) {
        return pacienteService.update(id, novo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pacienteService.deleteById(id);
    }
}
