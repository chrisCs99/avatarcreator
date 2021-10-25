package com.example.avatarcreator.usecase;

import com.example.avatarcreator.dto.AvatarDisplayDto;
import com.example.avatarcreator.dto.AvatarDto;

import java.util.List;

public interface AvatarUseCase {

    void register(AvatarDto avatar);

    List<AvatarDisplayDto> getAll();
}
