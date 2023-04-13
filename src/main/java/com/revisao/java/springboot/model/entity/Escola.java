package com.revisao.java.springboot.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Escola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @OneToOne
    @JoinColumn(name = "idEndereco", nullable = false)
    private Endereco endereco;

    @OneToMany(mappedBy = "escola")
    private List<Professor> listaDeProfessores;

    @OneToMany
    @JoinColumn(name = "idEscola", nullable = false)
    private List<Curso> listaDeCursos;

}
