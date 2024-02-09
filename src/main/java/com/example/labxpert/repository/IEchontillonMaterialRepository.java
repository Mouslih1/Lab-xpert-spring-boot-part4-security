package com.example.labxpert.repository;

import com.example.labxpert.model.EchontillonMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEchontillonMaterialRepository extends JpaRepository<EchontillonMaterial,Long> {
    List<EchontillonMaterial> findByDeletedFalse();
    Optional<EchontillonMaterial> findByIdAndDeletedFalse(Long id);
    List<EchontillonMaterial> findByQuantityBeforeAndDeletedFalse(int quantity);
    List<EchontillonMaterial> findByPriceTotalBeforeAndDeletedFalse(double priceTotal);
}
