package com.ufro.tiendasport.services;

import com.ufro.tiendasport.models.LoginDTO;
import com.ufro.tiendasport.models.RegisterDTO;
import com.ufro.tiendasport.models.Role;
import com.ufro.tiendasport.models.User;
import com.ufro.tiendasport.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private UserRepository usuarioRepository;

    public void registrarUsuario(RegisterDTO registerDTO) throws Exception {
// Verificar integridad de los datos
        verificarDatos(registerDTO);
// Verificar correo electronico unico
        verificarCorreoUnico(registerDTO.getCorreo());
// Crear objeto Usuario
        User usuario = new User();
        usuario.setNombre(registerDTO.getNombre());
        usuario.setCorreo(registerDTO.getCorreo());
        usuario.setContrasena(registerDTO.getContrasena());
        usuario.setRol(registerDTO.getRol());
        usuarioRepository.save(usuario);
    }



    private void verificarCorreoUnico(String correo) throws Exception {
        Optional<User> usuario =
                usuarioRepository.findByCorreo(correo);
        if (usuario.isPresent()) throw new Exception("Correo ya se encuentra registrado");
    }
    private void verificarDatos(RegisterDTO registerDTO) throws Exception
    {
        if (registerDTO.getNombre() == null) throw new Exception("Nombre no ingresado");
        if (registerDTO.getCorreo() == null) throw new Exception("Correo no ingresado");
        if (registerDTO.getContrasena() == null) throw new Exception("Contraseña no ingresada");
        if (registerDTO.getRol() == null) throw new Exception("Rol no ingresado");
    }
    public Role login(LoginDTO loginDTO) throws Exception {
// Verificar si el usuario existe
        User usuario = usuarioRepository.findByCorreo(loginDTO.getCorreo()).orElseThrow(() -> new Exception("Usuario no existe"));
// Verificar contraseña correcta
        if(!usuario.getContrasena().equals(loginDTO.getContrasena())){
            throw new Exception("Contraseña Incorrecta");
        }
        usuarioRepository.save(usuario);
        return usuario.getRol();
    }
}
