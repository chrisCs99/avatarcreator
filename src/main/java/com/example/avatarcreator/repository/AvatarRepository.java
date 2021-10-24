package com.example.avatarcreator.repository;

import com.example.avatarcreator.entity.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {
}
