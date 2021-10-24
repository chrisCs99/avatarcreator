package com.example.avatarcreator.controller;

import com.example.avatarcreator.dto.AvatarDto;
import com.example.avatarcreator.endpoint.AvatarEndPoint;
import com.example.avatarcreator.usecase.AvatarUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.avatarcreator.endpoint.AvatarEndPoint.*;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@Slf4j
@RequestMapping(path = AvatarEndPoint.BASE)
public class AvatarController {

    private AvatarUseCase avatarUseCase;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(REGISTER)
    ResponseEntity register(@RequestBody AvatarDto avatar){
        try {
            this.avatarUseCase.register(avatar);
            return ok("Registro Exitoso");
        } catch (Exception e) {
            System.out.println("Ocurrio un error al registrar el avatar: [{}]\n" + avatar + "\n" + e.getMessage());
            return  ok("Bad Request" + e.getMessage());
        }
    }

}
