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
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

//    @ManyToMany(mappedBy = "listaDeDisciplinas")
//    private List<Curso> listaDeCursos;

    @ManyToMany(mappedBy = "listaDeDisciplinas")
    private List<Professor> listaDeProfessores;
}
