package com.consultoriomedico.sistema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.consultoriomedico.sistema.model.Medico;

@Repository
public interface MedicoDAO extends JpaRepository<Medico, Long> {
}
