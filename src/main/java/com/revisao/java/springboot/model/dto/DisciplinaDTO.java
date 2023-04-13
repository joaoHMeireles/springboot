package com.revisao.java.springboot.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DisciplinaDTO {
    @NotBlank
    private String nome;
}
