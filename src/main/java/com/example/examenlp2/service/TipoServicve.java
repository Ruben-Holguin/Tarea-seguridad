package com.example.examenlp2.service;

import com.example.examenlp2.entity.Tipo;

import java.util.List;
import java.util.Optional;

public interface TipoServicve {
    Tipo create(Tipo tipo);
    Tipo update(Tipo tipo);
    Optional<Tipo> read(Long id);
    void delete(Long id);
    List<Tipo> readAll();
}
