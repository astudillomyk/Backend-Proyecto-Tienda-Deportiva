package com.ufro.tiendasport.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String correo;
    @Column(nullable = false)
    private String contrasena;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role rol;
}