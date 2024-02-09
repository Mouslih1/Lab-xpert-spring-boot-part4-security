package com.example.labxpert.repository;

import com.example.labxpert.model.Analyse;
import com.example.labxpert.model.Enum.TypeAnalyse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IAnalyseRepository extends JpaRepository<Analyse,Long> {
    List<Analyse> findByDeletedFalse();
    Optional<Analyse> findByIdAndDeletedFalse(Long id);
    Optional<Analyse> findByTypeAnalyseAndDeletedFalse(TypeAnalyse typeAnalyse);
    List<Analyse> findByDateDebutBetween(LocalDate dateStart, LocalDate dateEnd);
}
