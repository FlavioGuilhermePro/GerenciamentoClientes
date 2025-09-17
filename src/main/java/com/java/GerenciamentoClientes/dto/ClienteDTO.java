package com.java.GerenciamentoClientes.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    private int idade;

}
