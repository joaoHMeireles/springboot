package com.revisao.java.springboot.model.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EnderecoDTO {

    @NotBlank
    private Long cep;

    @NotBlank
    private String rua;

    @Digits(integer = 5, fraction = 0)
    private Integer numero;

    @NotBlank
    private String cidade;

    @NotBlank
    private String estado;

    @NotBlank
    private String bairro;

}
