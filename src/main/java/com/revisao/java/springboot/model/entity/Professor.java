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
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 13)
    private String telefone;

    @OneToOne
    @JoinColumn(name = "idEndereco", nullable = false)
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "idEscola", nullable = false)
    private Escola escola;

    @ManyToMany
    private List<Disciplina> listaDeDisciplinas;
}
