package com.example.avatarcreator.dto;

import com.example.avatarcreator.entity.Part;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class AvatarDto {
    private Long eye;
    private Long head;
    private Long colorSkin;
    private Long ear;
    private Long mouth;
    private Long nose;
    private Long userId;
}
