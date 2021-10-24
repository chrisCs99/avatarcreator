package com.example.avatarcreator.usecase;

import com.example.avatarcreator.entity.Feature;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FeatureUseCase {

    void register(MultipartFile imageFile, String name, Long categoryId) throws Exception;
    void update(Long id, MultipartFile imageFile, String name, Long categoryId) throws Exception;
    Feature get(Long id) throws Exception;
    List<Feature> getAll() throws Exception;
}
