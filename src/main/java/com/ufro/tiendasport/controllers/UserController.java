package com.ufro.tiendasport.controllers;

import com.ufro.tiendasport.models.LoginDTO;
import com.ufro.tiendasport.models.RegisterDTO;
import com.ufro.tiendasport.models.Role;
import com.ufro.tiendasport.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
public class UserController {
    @Autowired
    private UserServices usuarioServices;
    @PostMapping("/registrar")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> registrarUsuario(@RequestBody RegisterDTO registerDTO){
        try{
            usuarioServices.registrarUsuario(registerDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario Registrado correctamente");
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        try {
            Role rol = usuarioServices.login(loginDTO);
            return ResponseEntity.accepted().body(rol);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}