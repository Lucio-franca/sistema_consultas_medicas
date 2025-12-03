package com.consultoriomedico.sistema.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.consultoriomedico.sistema.model.Consulta;
import com.consultoriomedico.sistema.service.ConsultaService;

@RestController
@RequestMapping("/consultas")
@CrossOrigin("*")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping("/todos")
    public List<Consulta> listar() {
        return consultaService.findAll();
    }

    @GetMapping("/{id}")
    public Consulta buscar(@PathVariable Long id) {
        return consultaService.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Consulta salvar(@RequestBody Consulta consulta) {
        return consultaService.save(consulta);
    }

    @PutMapping("/{id}")
    public Consulta atualizar(@PathVariable Long id, @RequestBody Consulta novo) {
        return consultaService.update(id, novo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        consultaService.deleteById(id);
    }
}
