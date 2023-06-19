package com.ufro.tiendasport.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterDTO {
    private String nombre;
    private String correo;
    private String contrasena;
    private Role rol;
}
