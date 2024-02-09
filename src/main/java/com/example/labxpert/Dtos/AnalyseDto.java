package com.example.labxpert.Dtos;

import com.example.labxpert.model.Analyse;
import com.example.labxpert.model.Enum.StatusAnalyse;
import com.example.labxpert.model.Enum.StatusResult;
import com.example.labxpert.model.Enum.TypeAnalyse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link Analyse}
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnalyseDto implements Serializable {
    Long id;

    @JsonIgnoreProperties(value = "analyses")
    @NotNull
    UserDto technicienResponsable;

    @NotNull
    TypeAnalyse typeAnalyse;

    @NotBlank
    String commantaires;

    @NotNull
    StatusAnalyse statusAnalyse;

    StatusResult statusResult;

    @NotNull
    LocalDate dateDebut;

    @NotNull
    @FutureOrPresent
    LocalDate dateFin;

    @JsonIgnore
    @Builder.Default
    Boolean deleted = false;

    @JsonIgnoreProperties(value = "analyse")
    List<SousAnalyseDto> sousAnalyses;
}