package com.example.labxpert.model;

import com.example.labxpert.model.Enum.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "users")
public class User extends Person {

    @Column(unique = true)
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonIgnore
    @Column(name = "is_deleted")
    private Boolean deleted;

    @ToString.Exclude
    @OneToMany(mappedBy = "technicienResponsable")
    private List<Analyse> analyses = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "technicien")
    private List<Planification> planifications = new ArrayList<>();
}
