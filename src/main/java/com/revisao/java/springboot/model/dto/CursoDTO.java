package com.revisao.java.springboot.model.dto;

import com.revisao.java.springboot.model.entity.Disciplina;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CursoDTO {
    @NotBlank
    private String nome;

    @NotNull
    private List<Disciplina> listaDeDisciplinas;
}
