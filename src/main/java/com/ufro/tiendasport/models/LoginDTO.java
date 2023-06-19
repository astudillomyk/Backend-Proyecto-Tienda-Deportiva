package com.ufro.tiendasport.models;

import lombok.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginDTO implements Serializable {
    private String correo;
    private String contrasena;
}
