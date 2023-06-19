package com.ufro.tiendasport.repositories;

import com.ufro.tiendasport.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByCorreo(String correo);
}