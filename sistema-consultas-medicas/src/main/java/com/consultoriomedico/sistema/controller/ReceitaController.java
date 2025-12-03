package com.consultoriomedico.sistema.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.consultoriomedico.sistema.model.Receita;
import com.consultoriomedico.sistema.service.ReceitaService;

@RestController
@RequestMapping("/receitas")
@CrossOrigin("*")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @GetMapping("/todos")
    public List<Receita> listar() {
        return receitaService.findAll();
    }

    @GetMapping("/{id}")
    public Receita buscar(@PathVariable Long id) {
        return receitaService.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Receita salvar(@RequestBody Receita receita) {
        return receitaService.save(receita);
    }

    @PutMapping("/{id}")
    public Receita atualizar(@PathVariable Long id, @RequestBody Receita novo) {
        return receitaService.update(id, novo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        receitaService.deleteById(id);
    }
}
