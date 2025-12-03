package com.consultoriomedico.sistema.service;

import com.consultoriomedico.sistema.dao.MedicoDAO;
import com.consultoriomedico.sistema.model.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoDAO medicoDAO;

    public List<Medico> findAll() {
        return medicoDAO.findAll();
    }

    public Optional<Medico> findById(Long id) {
        return medicoDAO.findById(id);
    }

    public Medico save(Medico medico) {
        return medicoDAO.save(medico);
    }

    public Medico update(Long id, Medico novo) {
        Medico medico = medicoDAO.findById(id).orElse(null);
        if (medico == null) return null;

        medico.setNome(novo.getNome());
        medico.setEmail(novo.getEmail());
        medico.setTelefone(novo.getTelefone());
        medico.setEspecialidade(novo.getEspecialidade());


        return medicoDAO.save(medico);
    }

    public void deleteById(Long id) {
        medicoDAO.deleteById(id);
    }
}
