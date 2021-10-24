package com.example.avatarcreator.usecase;

import com.example.avatarcreator.dto.UserDto;
import com.example.avatarcreator.entity.Category;
import com.example.avatarcreator.entity.Feature;
import com.example.avatarcreator.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CategoryUseCase {
    void register(String name);

    void update(String name, Long id);

    void delete(Long id);

    List<Category> getAll();
}
