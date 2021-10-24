package com.example.avatarcreator.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class UserDto {
    private String name;

    private String lastName;

    private String userName;

    private String password;

    private String email;
}
