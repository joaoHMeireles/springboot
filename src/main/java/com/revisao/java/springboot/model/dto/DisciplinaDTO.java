package com.revisao.java.springboot.model.dto;

import com.revisao.java.springboot.model.entity.Professor;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class DisciplinaDTO {
    @NotBlank
    private String nome;

    private List<Professor> listaDeProfessores;
}
