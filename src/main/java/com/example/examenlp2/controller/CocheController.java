package com.example.examenlp2.controller;

import com.example.examenlp2.entity.Coche;
import com.example.examenlp2.service.CocheService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/coches")
@CrossOrigin(origins = "http://localhost:4200")
public class CocheController {
    @Autowired
    private CocheService cocheService;

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping
    public ResponseEntity<List<Coche>> readAll(){
        try {
            List<Coche> coches = cocheService.readAll();
            if(coches.isEmpty()) {
                return new ResponseEntity<List<Coche>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(coches, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Coche> crear(@Valid @RequestBody Coche coche) {
        try {
            Coche c = cocheService.create(coche);
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Coche> getCocheId(@PathVariable("id") Long id){
        try {
            Coche c = cocheService.read(id).get();
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Coche> delCoche(@PathVariable("id") Long id){
        try {
            cocheService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCoche(@PathVariable("id") Long id, @Valid @RequestBody Coche Coche){

        Optional<Coche> c = cocheService.read(id);
        if(c.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(cocheService.update(Coche), HttpStatus.OK);
        }

    }
}
