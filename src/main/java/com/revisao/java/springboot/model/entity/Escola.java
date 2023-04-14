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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEndereco", nullable = false)
    private Endereco endereco;

    @OneToMany(mappedBy = "escola", cascade = CascadeType.ALL)
    private List<Professor> listaDeProfessores;

    @OneToMany(mappedBy = "escola", cascade = CascadeType.ALL)
    private List<Curso> listaDeCursos;

}
