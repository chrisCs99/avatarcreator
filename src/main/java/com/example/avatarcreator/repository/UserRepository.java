package com.example.avatarcreator.repository;

import com.example.avatarcreator.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT s FROM User s " +
            "WHERE s.userName = :userName " +
            "AND s.password = :password")
    User findByUserNameAndPassword(@Param("userName") String userName,
                                   @Param("password") String password);
}
