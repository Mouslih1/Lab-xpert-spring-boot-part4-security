package com.example.labxpert.repository;

import com.example.labxpert.model.Echontillon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEchontillonRepository extends JpaRepository<Echontillon, Long> {
    List<Echontillon> findByDeletedFalse();
    Optional<Echontillon> findByIdAndDeletedFalse(Long id);
    Optional<Echontillon> findByCodeEchontillonAndDeletedFalse(String codeEchontillon);

}
