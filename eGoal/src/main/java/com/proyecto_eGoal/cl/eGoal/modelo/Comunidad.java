package com.proyecto_eGoal.cl.eGoal.modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name="Comunidad")

public class Comunidad {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private String nombreComunidad;

    @Column(nullable=true)
    private String descripcion;

    @Column(nullable=false)
    private Date fechaCreacion;

    @ManyToOne
    @JoinColumn(name="usuario_id",nullable=false)
    private Usuario usuario;


    

}
