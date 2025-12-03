package com.consultoriomedico.sistema.service;

import com.consultoriomedico.sistema.dao.ReceitaDAO;
import com.consultoriomedico.sistema.model.Receita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaDAO receitaDAO;

    public List<Receita> findAll() {
        return receitaDAO.findAll();
    }

    public Optional<Receita> findById(Long id) {
        return receitaDAO.findById(id);
    }

    public Receita save(Receita receita) {
        return receitaDAO.save(receita);
    }

    public Receita update(Long id, Receita novo) {
        Receita receita = receitaDAO.findById(id).orElse(null);
        if (receita == null) return null;

        receita.setConsulta(novo.getConsulta());
        receita.setMedicamentos(novo.getMedicamentos());
        receita.setPosologia(novo.getPosologia());

        return receitaDAO.save(receita);
    }

    public void deleteById(Long id) {
        receitaDAO.deleteById(id);
    }
}
