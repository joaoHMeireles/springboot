package com.revisao.java.springboot.model.dto;

import com.revisao.java.springboot.model.entity.Endereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AlunoDTO {
    @NotBlank
    private String nome;

    @Email
    private String email;

    @NotBlank
    private String telefone;

    @NotNull
    private Endereco endereco;
}
