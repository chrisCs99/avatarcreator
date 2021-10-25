package com.example.avatarcreator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class AvatarDisplayDto {
    private Long eye;
    private String pathEye;
    private Long head;
    private String pathHead;
    private Long colorSkin;
    private String pathColorSkin;
//    private Long ear;
//    private String pathEar;
    private Long mouth;
    private String pathMouth;
//    private Long nose;
//    private String pathNose;
    private Long userId;
    private String pathUserId;
}
