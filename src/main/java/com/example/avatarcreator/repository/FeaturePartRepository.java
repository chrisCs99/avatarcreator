package com.example.avatarcreator.repository;

import com.example.avatarcreator.entity.FeaturePart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeaturePartRepository extends JpaRepository<FeaturePart, Long> {
    void deleteFeaturePartByPart(Long id);
}
