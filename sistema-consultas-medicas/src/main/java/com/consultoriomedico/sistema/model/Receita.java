package com.consultoriomedico.sistema.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "receita")
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "consulta_id", nullable = false)
    private Consulta consulta;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String medicamentos;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String posologia;
}