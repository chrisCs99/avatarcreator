package com.example.avatarcreator.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "parts")
public class Part {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

}
