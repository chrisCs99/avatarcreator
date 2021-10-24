package com.example.avatarcreator.repository;

import com.example.avatarcreator.entity.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
}
