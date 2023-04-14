package com.revisao.java.springboot.model.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class EnderecoDTO {

    @Min(10000000)
    @Digits(integer = 8, fraction = 0)
    private Long cep;

    @NotBlank
    private String rua;

    @Digits(integer = 5, fraction = 0)
    @Positive
    private Integer numero;

    @NotBlank
    private String cidade;

    @NotBlank
    private String estado;

    @NotBlank
    private String bairro;

}
