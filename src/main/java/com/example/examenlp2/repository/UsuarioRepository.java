package com.example.examenlp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.examenlp2.entity.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByUsername(String username);
}
