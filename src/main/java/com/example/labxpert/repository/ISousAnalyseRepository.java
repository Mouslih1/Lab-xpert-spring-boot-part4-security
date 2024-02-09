package com.example.labxpert.repository;

import com.example.labxpert.model.SousAnalyse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISousAnalyseRepository extends JpaRepository<SousAnalyse,Long> {
    List<SousAnalyse> findByDeletedFalse();
    Optional<SousAnalyse> findByIdAndDeletedFalse(Long id);
    Optional<SousAnalyse> findByTitleAndDeletedFalse(String title);
    List<SousAnalyse> findByAnalyseIdAndDeletedFalse(Long id);
}
