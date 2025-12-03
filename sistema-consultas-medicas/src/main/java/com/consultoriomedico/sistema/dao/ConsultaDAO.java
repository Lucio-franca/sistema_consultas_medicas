package com.consultoriomedico.sistema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.consultoriomedico.sistema.model.Consulta;

@Repository
public interface ConsultaDAO extends JpaRepository<Consulta, Long> {
}
