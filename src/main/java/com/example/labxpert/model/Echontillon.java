package com.example.labxpert.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "echontillons")
public class Echontillon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codeEchontillon;

    @ManyToOne
    private Patient patient;

    private LocalDate date_p;

    @JsonIgnore
    @Column(name = "is_deleted")
    private Boolean deleted;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Analyse> analyses = new ArrayList<>();
}
