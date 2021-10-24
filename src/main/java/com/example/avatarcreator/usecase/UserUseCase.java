package com.example.avatarcreator.usecase;

import com.example.avatarcreator.dto.UserDto;
import com.example.avatarcreator.entity.User;

import java.util.List;

public interface UserUseCase {

    void register(UserDto user);

    void update(UserDto user, Long id);

    void delete(Long id);

    List<User> getAll();
}
