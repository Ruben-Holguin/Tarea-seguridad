package com.example.examenlp2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="coches")
public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="placa")
    private String placa;
    @Column(name="puertas")
    private int puertas;
    @ManyToOne
    @JoinColumn(name="marca_id", nullable = false)
    private Marca marca;
    @ManyToOne
    @JoinColumn(name="tipo_id", nullable = false)
    private Tipo tipo;
}
