package com.example.avatarcreator.repository;

import com.example.avatarcreator.dto.AvatarDisplayDto;
import com.example.avatarcreator.entity.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {

    @Query("SELECT new com.example.avatarcreator.dto.AvatarDisplayDto(" +
            "a.eye.id, eye.feature.imagePath, a.head.id, hd.feature.imagePath, " +
            "a.colorSkin.id, csk.feature.imagePath, a.mouth.id, mth.feature.imagePath, " +
            "a.id, us.user.userName) " +
            "FROM Avatar a " +
            "JOIN FeaturePart eye " +
            "ON eye.part.id = a.eye.id " +
            "JOIN FeaturePart hd " +
            "ON hd.part.id = a.head.id " +
            "JOIN FeaturePart csk " +
            "ON csk.part.id = a.colorSkin.id " +
            "JOIN FeaturePart mth " +
            "ON mth.part.id = a.mouth.id " +
            "JOIN UserAvatar us " +
            "ON us.avatar.id = a.id")
    List<AvatarDisplayDto> getAll();

}
