package com.revisao.java.springboot.model.dto;

import com.revisao.java.springboot.model.entity.Aluno;
import com.revisao.java.springboot.model.entity.Escola;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class TurmaDTO {

    @NotBlank
    private String nome;

    @NotNull
    private Escola escola;

    @NotNull
    private List<Aluno> listaDeAlunos;
}
