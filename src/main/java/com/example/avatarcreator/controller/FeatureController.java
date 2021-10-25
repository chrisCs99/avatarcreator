package com.example.avatarcreator.controller;

import com.example.avatarcreator.dto.FeatureDto;
import com.example.avatarcreator.endpoint.FeatureEndPoint;
import com.example.avatarcreator.entity.Feature;
import com.example.avatarcreator.usecase.FeatureUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@Slf4j
@RequestMapping(path = FeatureEndPoint.BASE)
public class FeatureController implements FeatureEndPoint {
    @Autowired
    private FeatureUseCase featureUseCase;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(REGISTER)
    ResponseEntity register(@RequestBody MultipartFile imageFile, @RequestParam String name, @RequestParam Long categoryId){
        try {
            this.featureUseCase.register(imageFile, name, categoryId);
            return ok("Registro Exitoso");
        } catch (Exception e) {
            System.out.println("Ocurrio un error al registrar el feature: [{}]\n" + e.getMessage());
            return  ok("Bad Request" + e.getMessage());
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(UPDATE_FEATURE)
    ResponseEntity update(@PathVariable Long id, MultipartFile imageFile, String name, @RequestParam Long categoryId){
        try {
            this.featureUseCase.update(id, imageFile, name, categoryId);
            return ok("Actualización Exitosa");
        } catch (Exception e) {
            System.out.println("Ocurrio un error al actualizar el feature id: [{}]\n" + id + "\n" + e.getMessage());
            return  ok("Bad Request" + e.getMessage());
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(GET)
    ResponseEntity getOne(@PathVariable Long id){
        try {
            Feature feat =  this.featureUseCase.get(id);
            return ok(feat);
        } catch (Exception e) {
            System.out.println("Ocurrio un error al obtener el feature id: [{}]\n" + id + "\n" + e.getMessage());
            return  ok("Bad Request" + e.getMessage());
        }
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = GETALL)
    ResponseEntity getAll(){
        try {
            List<FeatureDto> feat =  this.featureUseCase.getAll();
            return ok(feat);
        } catch (Exception e) {
            System.out.println("Ocurrio un error al obtener el listado de features: [{}]\n" + e.getMessage());
            return  ok("Bad Request" + e.getMessage());
        }
    }
}
