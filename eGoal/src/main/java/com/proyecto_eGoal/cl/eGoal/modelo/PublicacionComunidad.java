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
@Table (name="publicacion_comunidad")
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class PublicacionComunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private String tituloPublicacion;

    @Column(length = 300,nullable=false)
    private String publiComunidad;

    @Column(nullable = false)
    private Date fechaPubliComunidad;

    @ManyToOne
    @JoinColumn(name="usuario_id",nullable = false)
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name="comunidad_id",nullable = false)
    private Comunidad comunidad;

}
