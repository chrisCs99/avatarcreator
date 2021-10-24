package com.example.avatarcreator.service;

import com.example.avatarcreator.dto.UserDto;
import com.example.avatarcreator.entity.Category;
import com.example.avatarcreator.entity.Feature;
import com.example.avatarcreator.repository.CategoryRepository;
import com.example.avatarcreator.repository.FeatureRepository;
import com.example.avatarcreator.usecase.FeatureUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Service
public class FeatureService implements FeatureUseCase {

    @Autowired
    private FeatureRepository featureRepository;

    private CategoryRepository categoryRepository;

    @Override
    public void register(MultipartFile imageFile, String name, Long categoryId) throws Exception {
        String folder = "/images/";
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder + imageFile.getOriginalFilename());
        Files.write(path, bytes);

        Feature feature = new Feature();
        feature.setImagePath(feature.getImagePath());
        feature.setName(name);
        feature.setCategory(null);
        if (categoryId > 0) {
            Category c = this.categoryRepository.getOne(categoryId);
            feature.setCategory(c);
        }

        this.featureRepository.save(feature);
    }

    @Override
    public void update(Long id, MultipartFile imageFile, String name, Long categoryId) throws Exception {
        String folder = "/images/";
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder + imageFile.getOriginalFilename());
        Files.write(path, bytes);

        Feature feature = this.featureRepository.getOne(id);
        feature.setImagePath(feature.getImagePath());
        feature.setName(name);
        feature.setCategory(null);
        if (categoryId > 0) {
            Category c = this.categoryRepository.getOne(categoryId);
            feature.setCategory(c);
        }

        this.featureRepository.save(feature);
    }

    @Override
    public Feature get(Long id) throws Exception {
        return this.featureRepository.findById(id).get();
    }

    @Override
    public List<Feature> getAll() throws Exception {
        return this.featureRepository.findAll();
    }

}
