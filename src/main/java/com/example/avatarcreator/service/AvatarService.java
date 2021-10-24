package com.example.avatarcreator.service;

import com.example.avatarcreator.dto.AvatarDto;
import com.example.avatarcreator.entity.Avatar;
import com.example.avatarcreator.entity.Part;
import com.example.avatarcreator.entity.User;
import com.example.avatarcreator.entity.UserAvatar;
import com.example.avatarcreator.repository.AvatarRepository;
import com.example.avatarcreator.repository.PartRepository;
import com.example.avatarcreator.repository.UserAvatarRepository;
import com.example.avatarcreator.repository.UserRepository;
import com.example.avatarcreator.usecase.AvatarUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvatarService implements AvatarUseCase {

    @Autowired
    private AvatarRepository avatarRepository;
    private PartRepository partRepository;
    private UserRepository userRepository;
    private UserAvatarRepository userAvatarRepository;

    @Override
    public void register(AvatarDto avatar) {

        Part colorSkin = this.partRepository.getOne(avatar.getColorSkin());
        Part ear = this.partRepository.getOne(avatar.getEar());
        Part eye = this.partRepository.getOne(avatar.getEye());
        Part head = this.partRepository.getOne(avatar.getHead());
        Part mouth = this.partRepository.getOne(avatar.getMouth());
        Part nose = this.partRepository.getOne(avatar.getNose());

        User us = this.userRepository.getOne(avatar.getUserId());

        Avatar av = new Avatar();
        av.setColorSkin(colorSkin);
        av.setEar(ear);
        av.setEye(eye);
        av.setHead(head);
        av.setMouth(mouth);
        av.setNose(nose);

        Avatar temp = this.avatarRepository.save(av);

        UserAvatar userAvatar = new UserAvatar();
        userAvatar.setAvatar(temp);
        userAvatar.setUser(us);

        this.userAvatarRepository.save(userAvatar);
    }
}
