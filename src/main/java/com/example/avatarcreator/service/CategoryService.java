package com.example.avatarcreator.service;

import com.example.avatarcreator.entity.Category;
import com.example.avatarcreator.repository.CategoryRepository;
import com.example.avatarcreator.usecase.CategoryUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements CategoryUseCase {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public void register(String name) {
        Category c = new Category();
        c.setName(name);
        this.categoryRepository.save(c);
    }

    @Override
    public void update(String name, Long id) {
        Category c = this.categoryRepository.getOne(id);
        c.setName(name);

        this.categoryRepository.save(c);
    }

    @Override
    public void delete(Long id) {
        this.categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }
}
