package com.revisao.java.springboot.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(nullable = false)
    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEndereco", nullable = false)
    private Endereco endereco;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idEscola")
    private Escola escola;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Disciplina> listaDeDisciplinas;
}
