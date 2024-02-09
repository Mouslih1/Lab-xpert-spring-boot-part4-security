package com.example.labxpert.repository;

import com.example.labxpert.model.StockRecuperer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStockRecuperationRepository extends JpaRepository<StockRecuperer, Long> {
    Optional<StockRecuperer> findByMaterialIdAndEchontillonMaterialId(Long materialId, Long echontillonMaterialId);
    void deleteByEchontillonMaterialId(Long echontillonMaterialId);
}
