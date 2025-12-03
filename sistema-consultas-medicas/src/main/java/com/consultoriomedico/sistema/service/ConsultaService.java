package com.consultoriomedico.sistema.service;

import com.consultoriomedico.sistema.dao.ConsultaDAO;
import com.consultoriomedico.sistema.model.Consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaDAO consultaDAO;

    public List<Consulta> findAll() {
        return consultaDAO.findAll();
    }

    public Optional<Consulta> findById(Long id) {
        return consultaDAO.findById(id);
    }

    public Consulta save(Consulta consulta) {
        return consultaDAO.save(consulta);
    }

    public Consulta update(Long id, Consulta novo) {
        Consulta consulta = consultaDAO.findById(id).orElse(null);
        if (consulta == null) return null;

        consulta.setData_consulta(novo.getData_consulta());
        consulta.setPaciente(novo.getPaciente());
        consulta.setMedico(novo.getMedico());
        consulta.setObservacoes(novo.getObservacoes());

        return consultaDAO.save(consulta);
    }

    public void deleteById(Long id) {
        consultaDAO.deleteById(id);
    }
}
