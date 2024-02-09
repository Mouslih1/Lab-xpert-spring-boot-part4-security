package com.example.labxpert.repository;

import com.example.labxpert.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IMaterialRepository extends JpaRepository<Material, Long> {
    List<Material> findByDeletedFalse();
    Optional<Material> findByIdAndDeletedFalse(Long id);
    Optional<Material> findByLibelleAndDeletedFalse(String name);
    List<Material> findByPriceBeforeAndDeletedFalse(double price);
    List<Material> findByAvailableQuantityBeforeAndDeletedFalse(int availableQuantity);
}
