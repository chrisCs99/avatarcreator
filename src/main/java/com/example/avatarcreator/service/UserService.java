package com.example.avatarcreator.service;

import com.example.avatarcreator.dto.LoginDto;
import com.example.avatarcreator.dto.UserDto;
import com.example.avatarcreator.entity.User;
import com.example.avatarcreator.repository.UserRepository;
import com.example.avatarcreator.usecase.UserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserUseCase {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void register(UserDto user) {
        User saveUser = mapDtoToEntity(user);
        this.userRepository.save(saveUser);
    }

    @Override
    public void update(UserDto user, Long id) {
        User update = this.userRepository.getOne(id);
        update.setName(user.getName());
        update.setLastName(user.getLastName());
        update.setUserName(user.getUserName());
        update.setEmail(user.getEmail());
        update.setPassword(user.getPassword());

        this.userRepository.save(update);
    }

    @Override
    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User login(LoginDto login) {
        return this.userRepository.findByUserNameAndPassword(login.getUserName(), login.getPassword());
    }

    public User mapDtoToEntity(UserDto dto){
        User urs = new User();
        urs.setName(dto.getName());
        urs.setLastName(dto.getLastName());
        urs.setEmail(dto.getEmail());
        urs.setPassword(dto.getPassword());
        urs.setUserName(dto.getUserName());
        return  urs;
    }
}
