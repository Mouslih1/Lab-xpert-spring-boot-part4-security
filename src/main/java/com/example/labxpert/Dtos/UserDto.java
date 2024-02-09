package com.example.labxpert.Dtos;

import com.example.labxpert.model.Enum.Role;
import com.example.labxpert.model.Enum.Sexe;
import com.example.labxpert.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto implements Serializable {
    Long id;

    @NotBlank
    String nom;

    @NotBlank
    String prenom;

    @NotBlank
    @Size(min = 5)
    String address;

    @NotNull
    @Pattern(regexp = "^\\+?[0-9. ()-]{10,}$")
    String tel;

    @NotBlank
    String ville;

    @NotNull
    Sexe sexe;

    @NotNull
    @Past
    LocalDate dateNaissance;

    @NotNull
    @Email
    String email;

    @NotBlank
    @Size(min = 5)
    String password;

    @NotNull
    Role role;

    @JsonIgnore
    @Builder.Default
    Boolean deleted = false;

    @JsonIgnoreProperties(value = "technicienResponsable")
    List<AnalyseDto> analyses;
    @JsonIgnoreProperties(value = "technicien")
    List<PlanificationDto> planifications;
}