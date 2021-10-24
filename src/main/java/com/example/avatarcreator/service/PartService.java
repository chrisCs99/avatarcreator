package com.example.avatarcreator.service;

import com.example.avatarcreator.dto.PartDto;
import com.example.avatarcreator.entity.Category;
import com.example.avatarcreator.entity.Feature;
import com.example.avatarcreator.entity.FeaturePart;
import com.example.avatarcreator.entity.Part;
import com.example.avatarcreator.repository.FeaturePartRepository;
import com.example.avatarcreator.repository.FeatureRepository;
import com.example.avatarcreator.repository.PartRepository;
import com.example.avatarcreator.usecase.PartUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartService implements PartUseCase {

    @Autowired
    private PartRepository partRepository;
    private FeatureRepository featureRepository;
    private FeaturePartRepository featurePartRepository;

    @Override
    public void register(PartDto partDto) {
        Part part = new Part();
        part.setName(partDto.getName());
        Part temp = this.partRepository.save(part);
        if (!partDto.getFeature().isEmpty()){
            partDto.getFeature().forEach(e -> {
                Feature f = this.featureRepository.getOne(e.getId());
                FeaturePart featurePart = new FeaturePart();
                featurePart.setFeature(f);
                featurePart.setPart(temp);
                this.featurePartRepository.save(featurePart);
            });
        }
    }

    @Override
    public void update(PartDto partDto, Long id) {
        Part part = this.partRepository.getOne(id);
        part.setName(partDto.getName());
        Part temp = this.partRepository.save(part);
        if (!partDto.getFeature().isEmpty()){
            this.featurePartRepository.deleteFeaturePartByPart(id);
            partDto.getFeature().forEach(e -> {
                Feature f = this.featureRepository.getOne(e.getId());
                FeaturePart featurePart = new FeaturePart();
                featurePart.setFeature(f);
                featurePart.setPart(temp);
                this.featurePartRepository.save(featurePart);
            });
        }
    }

    @Override
    public void delete(Long id) {
        this.featurePartRepository.deleteFeaturePartByPart(id);
        this.partRepository.deleteById(id);
    }

    @Override
    public List<Category> getAll() {
        return null;
    }
}
