package com.example.avatarcreator.dto;

import com.example.avatarcreator.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class FeatureDto {
    private Long id;

    private String name;

    private String imagePath;

    private Long category;
}
