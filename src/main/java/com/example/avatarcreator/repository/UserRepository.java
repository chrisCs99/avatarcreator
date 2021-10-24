package com.example.avatarcreator.repository;

import com.example.avatarcreator.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
