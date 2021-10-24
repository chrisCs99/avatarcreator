package com.example.avatarcreator.controller;

import com.example.avatarcreator.endpoint.CategoryEndPoint;
import com.example.avatarcreator.entity.Category;
import com.example.avatarcreator.usecase.CategoryUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.avatarcreator.endpoint.CategoryEndPoint.*;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@Slf4j
@RequestMapping(path = CategoryEndPoint.BASE)
public class CategoryController {

    private CategoryUseCase categoryUseCase;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(REGISTER)
    ResponseEntity register(@RequestBody String name){
        try {
            this.categoryUseCase.register(name);
            return ok("Registro Exitoso");
        } catch (Exception e) {
            System.out.println("Ocurrio un error al registrar la categoria: [{}]\n" + name + "\n" + e.getMessage());
            return  ok("Bad Request" + e.getMessage());
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(GETALL)
    ResponseEntity getAll(){
        try {
            List<Category> lstUser = this.categoryUseCase.getAll();
            return ok(lstUser);
        } catch (Exception e) {
            System.out.println("Ocurrio un error al obtener las categorias: [{}]\n" + e.getMessage());
            return  ok("Bad Request" + e.getMessage());
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(UPDATE)
    ResponseEntity update(@PathVariable Long id, @RequestBody String name){
        try {
            this.categoryUseCase.update(name, id);
            return ok("Actualización Exitosa");
        } catch (Exception e) {
            System.out.println("Ocurrio un error al actualizar la cateogira: [{}]\n" + name + "\n" + e.getMessage());
            return  ok("Bad Request" + e.getMessage());
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(DELETE)
    ResponseEntity update(@PathVariable Long id){
        try {
            this.categoryUseCase.delete(id);
            return ok("Eliminación Exitosa");
        } catch (Exception e) {
            System.out.println("Ocurrio un error al eliminar la categoria id: [{}]\n" + id + "\n" + e.getMessage());
            return  ok("Bad Request" + e.getMessage());
        }
    }
}
