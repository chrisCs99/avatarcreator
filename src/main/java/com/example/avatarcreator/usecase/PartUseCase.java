package com.example.avatarcreator.usecase;

import com.example.avatarcreator.dto.PartDto;
import com.example.avatarcreator.entity.Category;

import java.util.List;

public interface PartUseCase {
    void register(PartDto partDto);

    void update(PartDto partDto, Long id);

    void delete(Long id);

    List<Category> getAll();

}
