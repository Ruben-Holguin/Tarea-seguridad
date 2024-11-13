package com.example.examenlp2.service;



import com.example.examenlp2.entity.Coche;

import java.util.List;
import java.util.Optional;

public interface CocheService {
    Coche create(Coche coche);
    Coche update(Coche cocheo);
    Optional<Coche> read(Long id);
    void delete(Long id);
    List<Coche> readAll();
}
