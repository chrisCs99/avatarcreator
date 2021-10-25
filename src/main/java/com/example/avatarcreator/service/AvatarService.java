package com.example.avatarcreator.service;

import com.example.avatarcreator.dto.AvatarDisplayDto;
import com.example.avatarcreator.dto.AvatarDto;
import com.example.avatarcreator.entity.*;
import com.example.avatarcreator.repository.*;
import com.example.avatarcreator.usecase.AvatarUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AvatarService implements AvatarUseCase {

    @Autowired
    private AvatarRepository avatarRepository;
//    private PartRepository partRepository;
    @Autowired
    private FeatureRepository partRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAvatarRepository userAvatarRepository;

    @Override
    public void register(AvatarDto avatar) {

//        Part colorSkin = this.partRepository.getOne(avatar.getColorSkin());
////        Part ear = this.partRepository.getOne(avatar.getEar());
//        Part eye = this.partRepository.getOne(avatar.getEye());
//        Part head = this.partRepository.getOne(avatar.getHead());
//        Part mouth = this.partRepository.getOne(avatar.getMouth());
////        Part nose = this.partRepository.getOne(avatar.getNose());

        Feature colorSkin = this.partRepository.getOne(avatar.getColorSkin());
//        Part ear = this.partRepository.getOne(avatar.getEar());
        Feature eye = this.partRepository.getOne(avatar.getEye());
        Feature head = this.partRepository.getOne(avatar.getHead());
        Feature mouth = this.partRepository.getOne(avatar.getMouth());
//        Part nose = this.partRepository.getOne(avatar.getNose());

        User us = this.userRepository.getOne(avatar.getUserId());

        Avatar av = new Avatar();
        av.setColorSkin(colorSkin);
//        av.setEar(ear);
        av.setEye(eye);
        av.setHead(head);
        av.setMouth(mouth);
        av.setUser(us);
//        av.setNose(nose);

        Avatar temp = this.avatarRepository.save(av);

//        UserAvatar userAvatar = new UserAvatar();
//        userAvatar.setAvatar(temp);
//        userAvatar.setUser(us);
//
//        this.userAvatarRepository.save(userAvatar);
    }

    @Override
    public List<AvatarDisplayDto> getAll() {
        List<Avatar> urs = this.avatarRepository.findAll();
        List<AvatarDisplayDto> dto = new ArrayList<>();
        urs.forEach(e -> {
            AvatarDisplayDto displayDto = new AvatarDisplayDto();
            displayDto.setEye(e.getEye().getId());
            displayDto.setPathEye(e.getEye().getImagePath());
            displayDto.setHead(e.getHead().getId());
            displayDto.setPathHead(e.getHead().getImagePath());
            displayDto.setColorSkin(e.getColorSkin().getId());
            displayDto.setPathColorSkin(e.getColorSkin().getImagePath());
            displayDto.setMouth(e.getMouth().getId());
            displayDto.setPathMouth(e.getMouth().getImagePath());
            displayDto.setUserId(e.getId());
            displayDto.setPathUserId(e.getUser().getUserName());

            dto.add(displayDto);
        });

        return dto;
    }
}
