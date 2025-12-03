package com.consultoriomedico.sistema.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.consultoriomedico.sistema.model.Paciente;

@Repository
public interface PacienteDAO extends JpaRepository<Paciente,Long>{
}
