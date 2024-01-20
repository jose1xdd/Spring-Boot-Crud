package com.unab.registro.entitys;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Document(value = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {
    @Id
    private String id;

    @NotBlank
    @NotNull
    @NotEmpty
    private String nombre;

    @NotBlank
    @NotNull
    @NotEmpty
    private String Apellido;

    @NotBlank
    @NotEmpty
    @NotNull
    private String celular;

    @NotBlank
    @NotEmpty
    @NotNull
    private String sexo;

    @NotBlank
    @NotNull
    @NotEmpty
    @Email
    private String email;
}
