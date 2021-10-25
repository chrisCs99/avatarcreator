package com.example.avatarcreator.controller;

import com.example.avatarcreator.dto.FeatureDto;
import com.example.avatarcreator.dto.PartDto;
import com.example.avatarcreator.endpoint.PartEndPoint;
import com.example.avatarcreator.usecase.PartUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.avatarcreator.endpoint.AvatarEndPoint.*;
import static org.springframework.http.ResponseEntity.ok;


@RestController
@Slf4j
@RequestMapping(path = PartEndPoint.BASE)
public class PartController implements PartEndPoint {
    @Autowired
    private PartUseCase partUseCase;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(REGISTER)
    ResponseEntity register(@RequestBody PartDto partDto){
        try {
            this.partUseCase.register(partDto);
            return ok("Registro Exitoso");
        } catch (Exception e) {
            System.out.println("Ocurrio un error al registrar el partDto: [{}]\n" + partDto + "\n" + e.getMessage());
            return  ok("Bad Request" + e.getMessage());
        }
    }
}
