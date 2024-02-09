package com.example.labxpert.Dtos;

import com.example.labxpert.model.Material;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * DTO for {@link Material}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MaterialDto implements Serializable {
    Long id;

    @NotNull
    String libelle;

    @Min(1)
    int availableQuantity;

    @Min(1)
    double price;

    @JsonIgnore
    @Builder.Default
    Boolean deleted = false;
}