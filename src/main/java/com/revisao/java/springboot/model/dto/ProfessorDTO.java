package com.revisao.java.springboot.model.dto;

import com.revisao.java.springboot.model.entity.Disciplina;
import com.revisao.java.springboot.model.entity.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class ProfessorDTO {
    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotBlank
    private String telefone;

    @NotNull
    private Endereco endereco;

    private List<Disciplina> listaDeDisciplinas;
}
