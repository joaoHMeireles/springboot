package com.revisao.java.springboot.model.dto;

import com.revisao.java.springboot.model.entity.Curso;
import com.revisao.java.springboot.model.entity.Endereco;
import com.revisao.java.springboot.model.entity.Professor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class EscolaDTO {
    @NotBlank
    private String nome;

    @Email
    private String email;

    @NotNull
    private Endereco endereco;

    private List<Professor> listaDeProfessores;

    private List<Curso> listaDeCursos;

}
