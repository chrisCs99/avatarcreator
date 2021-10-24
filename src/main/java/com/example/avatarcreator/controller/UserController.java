package com.example.avatarcreator.controller;

import com.example.avatarcreator.dto.UserDto;
import com.example.avatarcreator.endpoint.UserEndPoint;
import com.example.avatarcreator.entity.User;
import com.example.avatarcreator.usecase.UserUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@Slf4j
@RequestMapping(path = UserEndPoint.BASE)
public class UserController implements UserEndPoint {

    private UserUseCase userUseCase;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(REGISTER)
    ResponseEntity register(@RequestBody UserDto user){
        try {
            this.userUseCase.register(user);
            return ok("Registro Exitoso");
        } catch (Exception e) {
            System.out.println("Ocurrio un error al registrar el usuario: [{}]\n" + user + "\n" + e.getMessage());
            return  ok("Bad Request" + e.getMessage());
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(GETALL)
    ResponseEntity getAll(){
        try {
            List<User> lstUser = this.userUseCase.getAll();
            return ok(lstUser);
        } catch (Exception e) {
            System.out.println("Ocurrio un error al obtener los usuarios: [{}]\n" + e.getMessage());
            return  ok("Bad Request" + e.getMessage());
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(UPDATE)
    ResponseEntity update(@PathVariable Long id, @RequestBody UserDto user){
        try {
            this.userUseCase.update(user, id);
            return ok("Actualización Exitosa");
        } catch (Exception e) {
            System.out.println("Ocurrio un error al actualizar el usuario: [{}]\n" + user + "\n" + e.getMessage());
            return  ok("Bad Request" + e.getMessage());
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(DELETE)
    ResponseEntity update(@PathVariable Long id){
        try {
            this.userUseCase.delete(id);
            return ok("Eliminación Exitosa");
        } catch (Exception e) {
            System.out.println("Ocurrio un error al eliminar el usuario id: [{}]\n" + id + "\n" + e.getMessage());
            return  ok("Bad Request" + e.getMessage());
        }
    }

}
