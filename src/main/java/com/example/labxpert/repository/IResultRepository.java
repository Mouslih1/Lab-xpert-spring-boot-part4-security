package com.example.labxpert.repository;

import com.example.labxpert.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IResultRepository extends JpaRepository<Result,Long> {
    List<Result> findByDeletedFalse();
    Optional<Result> findByIdAndDeletedFalse(Long id);
}
