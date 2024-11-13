package com.example.examenlp2.service;

import com.example.examenlp2.entity.Marca;

import java.util.List;
import java.util.Optional;

public interface MarcaService {
    Marca create(Marca marca);
    Marca update(Marca marca);
    Optional<Marca> read(Long id);
    void delete(Long id);
    List<Marca> readAll();
}

