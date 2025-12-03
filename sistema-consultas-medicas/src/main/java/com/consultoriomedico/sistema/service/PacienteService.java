package com.consultoriomedico.sistema.service;

import com.consultoriomedico.sistema.dao.PacienteDAO;
import com.consultoriomedico.sistema.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteDAO pacienteDAO;

    public List<Paciente> findAll() {
        return pacienteDAO.findAll();
    }

    public Optional<Paciente> findById(Long id) {
        return pacienteDAO.findById(id);
    }

    public Paciente save(Paciente paciente) {
        return pacienteDAO.save(paciente);
    }

    public Paciente update(Long id, Paciente novo) {
        Paciente paciente = pacienteDAO.findById(id).orElse(null);
        if (paciente == null) return null;

        paciente.setNome(novo.getNome());
        paciente.setEmail(novo.getEmail());
        paciente.setTelefone(novo.getTelefone());
        paciente.setEndereco(novo.getEndereco());
        paciente.setData_nascimento(novo.getData_nascimento());

        return pacienteDAO.save(paciente);
    }

    public void deleteById(Long id) {
        pacienteDAO.deleteById(id);
    }
}
