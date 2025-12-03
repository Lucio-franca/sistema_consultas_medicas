package com.consultoriomedico.sistema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.consultoriomedico.sistema.model.Receita;

@Repository
public interface ReceitaDAO extends JpaRepository<Receita, Long> {
}
